package tbdp.model;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 17/2/18.
 * 规则参数配置
 */
public class RuleParamValConfig extends ToString {
    private String variParamID;
    private String variParamVal;
    private Long ruleID;
    private Long modID;

    public String getVariParamID() {
        return variParamID;
    }

    public void setVariParamID(String variParamID) {
        this.variParamID = variParamID;
    }

    public String getVariParamVal() {
        return variParamVal;
    }

    public void setVariParamVal(String variParamVal) {
        this.variParamVal = variParamVal;
    }

    public Long getRuleID() {
        return ruleID;
    }

    public void setRuleID(Long ruleID) {
        this.ruleID = ruleID;
    }

    public Long getModID() {
        return modID;
    }

    public void setModID(Long modID) {
        this.modID = modID;
    }
}
