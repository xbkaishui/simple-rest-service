package tbdp.util;

/**
 * Created by xbkaishui on 16/12/24.
 */
public class VarNameUtils {

    /**
     * 临时变量 开头是 tmp temp
     * @param var
     * @return
     */
    public static boolean isTempVar(String var) {
        return var.toLowerCase().startsWith("tmp") || var.toLowerCase().startsWith("temp");
    }
}
