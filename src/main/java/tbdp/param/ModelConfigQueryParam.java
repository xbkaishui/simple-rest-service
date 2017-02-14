package tbdp.param;

import java.util.Date;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class ModelConfigQueryParam {

    private Long modelId;
    private Integer modType;
    private Integer modPriority;
    private Date effDate;
    private Date expDate;
    private Integer status;
    private Integer userID;

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public Integer getModType() {
        return modType;
    }

    public void setModType(Integer modType) {
        this.modType = modType;
    }

    public Integer getModPriority() {
        return modPriority;
    }

    public void setModPriority(Integer modPriority) {
        this.modPriority = modPriority;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }
}
