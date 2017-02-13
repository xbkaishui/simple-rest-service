package tbdp.common;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by xbkaishui on 17/2/13.
 */
public class Result<T> extends ToString {
    T data;
    /**
     * 成功标志位
     */
    private boolean success = false;

    public Result() {
    }

    public Result(T data) {
        this.data = data;
        this.success = true;
    }

    public T getData() {
        return data;
    }

    public Result setData(T data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public Result setSuccess(boolean success) {
        this.success = success;
        return this;
    }
}
