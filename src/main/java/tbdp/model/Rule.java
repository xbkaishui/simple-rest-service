package tbdp.model;

import tbdp.common.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xbkaishui on 16-12-22.
 */
public class Rule extends ToString {

    private RuleConfig ruleConfig;

    private Serializable expression ;

    private List<Vari> vars;
    //是否包含历史批量指标
    private Boolean containBatchVar = false;

    public RuleConfig getRuleConfig() {
        return ruleConfig;
    }

    public void setRuleConfig(RuleConfig ruleConfig) {
        this.ruleConfig = ruleConfig;
    }

    public List<Vari> getVars() {
        return vars;
    }

    public void setVars(List<Vari> vars) {
        this.vars = vars;
    }

    public Serializable getExpression() {
        return expression;
    }

    public void setExpression(Serializable expression) {
        this.expression = expression;
    }

    public Boolean getContainBatchVar() {
        return containBatchVar;
    }

    public void setContainBatchVar(Boolean containBatchVar) {
        this.containBatchVar = containBatchVar;
    }
}
