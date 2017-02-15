package tbdp.common;

/**
 * Created by xbkaishui on 17/2/13.
 */
public class Result extends ToString {
    /**
     * 成功标志位
     */
    private boolean success = false;
    private String errorMsg;

    public Result() {
        setSuccess(true);
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Result setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }
}
