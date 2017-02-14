package tbdp.model;

import tbdp.common.ToString;

import java.util.Date;

/**
 * 模型配置对象
 * Created by xbkaishui on 16/12/18.
 */
public class ModConfig extends ToString {

    private Long modId;
    private String modName;
    private Integer modType;
    private Integer modPriority;
    private Date effDate;
    private Date expDate;
    private Integer status;
    private Integer userID;
    private String modDesc;

    public Long getModId() {
        return modId;
    }

    public void setModId(Long modId) {
        this.modId = modId;
    }

    public String getModName() {
        return modName;
    }

    public void setModName(String modName) {
        this.modName = modName;
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

    public String getModDesc() {
        return modDesc;
    }

    public void setModDesc(String modDesc) {
        this.modDesc = modDesc;
    }


}
