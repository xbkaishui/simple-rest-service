package tbdp.param;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class ModelQueryParam extends ToString {

    /***模型id**/
    private String mid;
    /***模型类型**/
    private String modelType;
    /***模型 规则id**/
    private String ruleId;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public String getRuleId() {
        return ruleId;
    }

    public void setRuleId(String ruleId) {
        this.ruleId = ruleId;
    }
}
