package tbdp.enums;

/**
 * Created by xbkaishui on 16/12/20.
 */
public enum ModType {

    CALC_VAR(10, "指标计算模型"), QUERY(90, "数据查询模型");
    private int type;
    private String desc;

    ModType(int type, String desc) {
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
