package tbdp.load;

import tbdp.dao.*;
import tbdp.dao.ibatis.*;
import tbdp.es.common.EsQueryField;
import tbdp.es.common.ExpressionUtils;
import tbdp.model.Model;
import tbdp.param.ModelQueryParam;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import tbdp.common.ExecutionContext;
import tbdp.enums.Status;
import tbdp.enums.VarSrcType;
import tbdp.load.DataLoadModel;
import tbdp.model.*;
import tbdp.param.ModelConfigQueryParam;
import tbdp.param.RuleParamValQueryParam;
import tbdp.util.DateParserUtils;
import tbdp.util.VarNameUtils;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xbkaishui on 17/2/18.
 * 查询查询模型
 */
public class ESModelQueryLoad {

    private static Pattern formatPattern =
        Pattern.compile("\\$\\{([a-zA-Z0-9.,:\\#\\/\\=_\\-\\+\\(\\)\\ ]+)\\}");

    private static final Logger logger = Logger.getLogger(ESModelQueryLoad.class);
    private static ModConfigDAO modelDAO = new ModelConfigIbatisDAOImpl();
    private static RuleConfigDAO ruleDAO = new RuleConfigIbatisDAOImpl();
    private static RuleModRelaDAO ruleModRelaDAO = new RuleModRelaIbatisDAOImpl();
    private static RuleParamValConfigDAO ruleParamValConfigDAO =
        new RuleParamValConfigIbatisDAOImpl();

    /**
     * 根据模型id 和模型类型 查询模型
     *
     * @param param
     * @return
     */
    public List<Model> queryModels(ModelQueryParam param) {
        logger.info("queryModels param " + param);
        List<Model> result = new ArrayList<>();

        ModelConfigQueryParam configQueryParam = new ModelConfigQueryParam();
        if (StringUtils.isNotEmpty(param.getMid())) {
            configQueryParam.setModelId(Long.valueOf(param.getMid()));
        }
        if (StringUtils.isNotEmpty(param.getModelType())) {
            configQueryParam.setModType(Integer.valueOf(param.getModelType()));
        }
        try {
            List<ModConfig> modConfigs = modelDAO.selectByParam(configQueryParam);

            for (ModConfig modConfig : modConfigs) {
                List<Rule> rules = new LinkedList<Rule>();
                Model model = new Model();
                model.setModConfig(modConfig);
                model.setRules(rules);
                result.add(model);

                String selectRuleId = param.getRuleId();
                List<RuleModRela> modelRels = ruleModRelaDAO.selectByModId(modConfig.getModId());
                for (RuleModRela modelRel : modelRels) {
                    if (StringUtils.isNotEmpty(selectRuleId)) {
                        if (!StringUtils
                            .equalsIgnoreCase(selectRuleId, String.valueOf(modelRel.getRuleID()))) {
                            continue;
                        }
                    }
                    Rule rule = new Rule();
                    RuleConfig ruleConfig = ruleDAO.selectById(modelRel.getRuleID());
                    rule.setRuleConfig(ruleConfig);
                    //剔除无效的规则
                    if (ruleConfig.getStatus() == Status.Valid.getVal()) {
                        initParamMap(rule);
                        rules.add(rule);
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return result;
    }



    /**
     * 初始化 规则的变量配置
     *
     * @param rule
     */
    public void initParamMap(Rule rule) throws Exception {
        long ruleId = rule.getRuleConfig().getRuleID();
        String ruleContext = rule.getRuleConfig().getRuleContext();
        logger.info("rule " + ruleId + "before substitute " + ruleContext);
        ruleContext = substituteVars(ruleContext, rule.getRuleConfig().getRuleID());
        logger.info("rule " + ruleId + "after substitute " + ruleContext);
        //set fields
        List<EsQueryField> fields = ExpressionUtils.parseRuleContext(ruleContext);
        rule.setQueryFields(fields);
    }


    public static String substituteVars(String format, long ruleId) throws Exception {
        if (!StringUtils.isEmpty(format)) {
            Matcher matcher = formatPattern.matcher(format);
            if (matcher.find()) {
                String variableName = matcher.group(1);
                RuleParamValQueryParam param = new RuleParamValQueryParam();
                param.setRuleID(ruleId);
                param.setVariParamID("${"+variableName+"}");
                List<RuleParamValConfig> paramVals = ruleParamValConfigDAO.selectByParam(param);
                Preconditions.checkState(paramVals != null && !paramVals.isEmpty());
                String val = paramVals.get(0).getVariParamVal();
                if (StringUtils.isNotEmpty(val)) {
                    format = matcher.replaceFirst(val);
                    return substituteVars(format, ruleId);
                }else{
                    throw new RuntimeException("error var " + variableName + " rule id "+ruleId);
                }
            }
        }
        return format;
    }
}
