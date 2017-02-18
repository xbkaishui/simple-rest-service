package tbdp.es.service;

import com.google.common.base.Joiner;
import org.apache.log4j.Logger;
import tbdp.es.common.EsQueryField;
import tbdp.es.domain.ModelQueryResult;
import tbdp.load.ESModelQueryLoad;
import tbdp.model.Model;
import tbdp.model.Rule;
import tbdp.param.ModelQueryParam;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsQueryService {

    private static final Logger logger = Logger.getLogger(EsQueryService.class);

    private static final ESModelQueryLoad queryLoad = new ESModelQueryLoad();

    private static final EsSqlClient sqlClient = EsSqlClient.instance();

    public ModelQueryResult queryModel(ModelQueryParam queryParam) {
        ModelQueryResult result = new ModelQueryResult();
        List<tbdp.es.domain.Model> esModels = new LinkedList<>();
        List<Model> models = queryLoad.queryModels(queryParam);
        try {
            //调用 es 接口查询数据
            for (Model model : models) {
                List<tbdp.es.domain.Model> returnModels = null;
                returnModels = queryEsEngine(model);
                esModels.addAll(returnModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        result.setModels(esModels);
        return result;
    }

    private List<tbdp.es.domain.Model> queryEsEngine(Model model) throws Exception {
        List<tbdp.es.domain.Model> models = new LinkedList<>();
        String index = "";
        String[] columns = {"scode", "markettype"};
        List<String> conditions = new LinkedList<>();
        List<Rule> rules = model.getRules();
        for (Rule rule : rules) {
            for (EsQueryField field : rule.getQueryFields()) {
                conditions.add(field.toCondition());
            }
        }
        logger.info(model.getModConfig().getModId() + " model query conditions " + conditions);

        String condStr = Joiner.on(" and  ").join(conditions);

        StringBuffer sqlBuf = new StringBuffer();
        sqlBuf.append("select ").append(Joiner.on(" , ").join(columns));
        sqlBuf.append(" from ").append(index).append(" where ");
        sqlBuf.append(condStr);

        logger.info(model.getModConfig().getModId() + " model query sql " + sqlBuf.toString());

        List<Map<String, String>> dataResults = sqlClient.query(sqlBuf.toString(), columns);
        for (Map<String, String> dataResult : dataResults) {
            tbdp.es.domain.Model mod = new tbdp.es.domain.Model();
            mod.setScode(dataResult.get(columns[0]));
            mod.setMarketType(dataResult.get(columns[1]));
            models.add(mod);
        }
        return models;
    }

}
