package tbdp.es.common;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xbkaishui on 17/2/18.
 */
public enum Operator {

    LTHAN(14,15), //<
    GTHAN(15,14), //>

    LETHAN(16,17),//>=
    GETHAN(17,16),//<=

    EQUAL(18), //=
    NEQUAL(19);//!=

    private int val;
    private int reverseVal = -1;

    private static Map<Integer, Operator> valueMap = new HashMap<>();

    static {
        for (Operator opr : Operator.values()) {
            valueMap.put(opr.val, opr);
        }
    }

    Operator(int val) {
        this.val = val;
    }

    Operator(int val,int reverseVal) {
        this.val = val;
        this.reverseVal = reverseVal;
    }


    public int getVal() {
        return val;
    }

    public int getReverseVal() {
        return reverseVal;
    }

    public Operator reverse(){
        return getByVal(reverseVal);
    }

    public static Operator getByVal(int val) {
        return valueMap.get(val);
    }

}
