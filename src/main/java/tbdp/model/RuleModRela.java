package tbdp.model;

import tbdp.common.ToString;

import java.util.Date;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleModRela extends ToString {
    private Long ruleID;
    private Long modID;
    private Integer priority;

    private Date effDate;
    private Date expDate;

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

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getEffDate() {
        return effDate;
    }

    public void setEffDate(Date effDate) {
        this.effDate = effDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }
}
