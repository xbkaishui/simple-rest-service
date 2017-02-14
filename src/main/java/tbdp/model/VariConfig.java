package tbdp.model;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class VariConfig extends ToString {
    private Long variID;
    private String variCode;
    private String variName;
    /**
     * 指标类型
     * 1.实时指标
     * 2.股票信息指标
     * 3.股票批量指标
     **/
    private Integer variType;
    private Integer variTag;
    private String variSrc;
    private String srcCol;
    private String srcColType;
    /**
     * 数据获取条件
     * kafka 获取 ${1}
     * HIVE 获取 date=${yyyymmdd-1}
     */
    private String srcCondition;

    public Long getVariID() {
        return variID;
    }

    public void setVariID(Long variID) {
        this.variID = variID;
    }

    public String getVariCode() {
        return variCode;
    }

    public void setVariCode(String variCode) {
        this.variCode = variCode;
    }

    public String getVariName() {
        return variName;
    }

    public void setVariName(String variName) {
        this.variName = variName;
    }

    public Integer getVariType() {
        return variType;
    }

    public void setVariType(Integer variType) {
        this.variType = variType;
    }

    public Integer getVariTag() {
        return variTag;
    }

    public void setVariTag(Integer variTag) {
        this.variTag = variTag;
    }

    public String getVariSrc() {
        return variSrc;
    }

    public void setVariSrc(String variSrc) {
        this.variSrc = variSrc;
    }

    public String getSrcCol() {
        return srcCol;
    }

    public void setSrcCol(String srcCol) {
        this.srcCol = srcCol;
    }

    public String getSrcColType() {
        return srcColType;
    }

    public void setSrcColType(String srcColType) {
        this.srcColType = srcColType;
    }

    public String getSrcCondition() {
        return srcCondition;
    }

    public void setSrcCondition(String srcCondition) {
        this.srcCondition = srcCondition;
    }
}
