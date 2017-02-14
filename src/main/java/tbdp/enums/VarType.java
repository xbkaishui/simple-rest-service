package tbdp.enums;

/**
 * Created by xbkaishui on 16/12/24.
 * 变量类型
 */
public enum VarType {
    RT(1, "实时指标"), STOCK_INFO(2, "股票信息"), BATCH(3, "批量指标");
    private int type;
    private String desc;

    VarType(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
