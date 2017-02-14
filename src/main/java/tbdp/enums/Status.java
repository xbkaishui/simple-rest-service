package tbdp.enums;

/**
 * Created by xbkaishui on 16/12/18.
 * 模型状态
 */
public enum Status {
    Invalid(0), Valid(1);
    private int val;

    Status(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}
