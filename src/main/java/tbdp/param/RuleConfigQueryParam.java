package tbdp.param;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleConfigQueryParam {

    private Long modelId;
    private Integer status;
    private int ruleType;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public int getRuleType() {
        return ruleType;
    }

    public void setRuleType(int ruleType) {
        this.ruleType = ruleType;
    }
}
