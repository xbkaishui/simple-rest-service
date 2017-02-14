package tbdp.model;

import tbdp.common.ToString;

import java.util.Date;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleConfig extends ToString {

    private long modId;
    private long ruleID;
    //公式类型
    private int ruleType;
    private String ruleContext;
    //状态(0:失效，1:生效)
    private int status;
    private Date changeDate;

    public long getRuleID() {
        return ruleID;
    }

    public void setRuleID(long ruleID) {
        this.ruleID = ruleID;
    }

    public int getRuleType() {
        return ruleType;
    }

    public void setRuleType(int ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleContext() {
        return ruleContext;
    }

    public void setRuleContext(String ruleContext) {
        this.ruleContext = ruleContext;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }

    public long getModId() {
        return modId;
    }

    public void setModId(long modId) {
        this.modId = modId;
    }
}
