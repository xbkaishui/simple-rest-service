package tbdp.expression;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class Functions {

    /**
     * 距离当前交易行情时间
     * @param hhmm
     * @return
     */
    public static int timelen(String hhmm) {
        int totalAM = 120;
        int hh = Integer.valueOf(hhmm.substring(0, 2));
        int mm = Integer.valueOf(hhmm.substring(2, 4));
        int distance = 0;
        if (hhmm.compareTo("0931") > 0 && hhmm.compareTo("1130") <= 0) {
            distance = (hh - 9) * 60 + (mm - 30);
        } else if (hhmm.compareTo("1300") >= 0 && hhmm.compareTo("1500") <= 0) {
            distance = totalAM + (hh - 13) * 60 + mm;
        } else if (hhmm.compareTo("1500") >= 0) {
            distance = 240;
        } else {
            distance = 0;
        }
        return distance;
    }
}
