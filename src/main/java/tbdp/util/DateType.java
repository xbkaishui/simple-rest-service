package tbdp.util;

import java.util.Calendar;

/**
 * 
 * @author xingbingbing.xb
 * @version $Id: DateType.java, v 0.1 2015-4-30 上午11:48:39 xingbingbing.xb Exp $
 */
public enum DateType {

    M("mm", Calendar.MONTH), D("d", Calendar.DATE), Y("y", Calendar.YEAR) , Min("mi" , Calendar.MINUTE);

    private String name;
    private int    cal;

    private DateType(String name, int cal) {
        this.name = name;
        this.cal = cal;
    }

    public String getName() {
        return name;
    }

    public int getCal() {
        return cal;
    }

    public static DateType parse(String data) {
        if (data.contains(Min.name) || data.contains("hh") || data.contains("ss")) {
            return Min;
        }
        if (data.contains(D.name)) {
            return D;
        } else if (data.contains(M.name) || data.contains("MM")) {
            return M;
        } else if (data.contains(Y.name)) {
            return Y;
        } else {
            throw new IllegalArgumentException("cant 'f find prope dateType");
        }
    }

}
