package tbdp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.time.DateUtils;

public class DateFormatUtil {
    public static final String FORMAT_1            = ",##0.00";
    public static final String FORMAT_2            = "0.00";
    public static final String FORMAT_3            = ",###";

    public static final String TIME_FORMAT_A       = "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_AA      = "yyyy-MM-dd HHmmss";
    public static final String TIME_FORMAT_B       = "yyyyMMddHHmmss";
    public static final String TIME_FORMAT_C       = "yyyy-MM-dd HH:mm:ss:SSS";
    public static final String TIME_FORMAT_D       = "yyyyMMdd";
    public static final String TIME_FORMAT_E       = "yyyy年MM月dd日";
    public static final String TIME_FORMAT_F       = "yyyyMMddHHmm";
    public static final String TIME_FORMAT_G       = "yyyy年MM月dd日HH时mm分ss秒";
    public static final String TIME_FORMAT_H       = "yyyy-MM-dd HH:mm";
    public static final String TIME_FORMAT_I       = "HH:mm:ss";
    public static final String TIME_FORMAT_II      = "HHmmss";
    public static final String TIME_FORMAT_J       = "yyyy/MM/dd";
    public static final String DATE_FORMAT         = "yyyy-MM-dd";
    public static final String YEAR_FORMAT         = "yyyy";
    public static final String YEAR_MONTH_FORMAT   = "yyyy-MM";
    public static final String YEAR_MONTH_FORMAT_A = "yyyyMM";
    public static final String YEAR_MONTH_FORMAT_B = "yyyymm";
    public static final String YEAR_MONTH_FORMAT_C = "yyyy/MM";

    public static String[]     parseDatePatterns   = { TIME_FORMAT_B, TIME_FORMAT_A,
            TIME_FORMAT_AA, DATE_FORMAT, TIME_FORMAT_F, TIME_FORMAT_D, YEAR_MONTH_FORMAT_A,
            YEAR_MONTH_FORMAT, TIME_FORMAT_I, TIME_FORMAT_II, TIME_FORMAT_J, YEAR_MONTH_FORMAT_B };

    public static String getYMDHMS(Date date) {
        SimpleDateFormat formate = new SimpleDateFormat(TIME_FORMAT_A);
        return formate.format(date);
    }

    public static String getYMD(Date date) {
        SimpleDateFormat formate = new SimpleDateFormat(DATE_FORMAT);
        return formate.format(date);
    }

    public static String parseDate(Date date, String format) {
        SimpleDateFormat formate = new SimpleDateFormat(format);
        return formate.format(date);
    }

    /**
     * 格式化时间:默认是yyyy-MM-dd HH:mm:ss或者yyyy-MM-dd
     * 
     * @param date
     * @param df
     * @return
     */
    public static Date parse(String date, Date df) {
        SimpleDateFormat sdf = null;
        try {
            if (date.length() == 10) {
                sdf = new SimpleDateFormat(DATE_FORMAT);
            } else if (date.length() == 14) {
                sdf = new SimpleDateFormat(TIME_FORMAT_B);
            } else {
                sdf = new SimpleDateFormat(TIME_FORMAT_A);
            }
            return sdf.parse(date);
        } catch (Exception e) {
            return df;
        }
    }

    /**
     * 时间类型转化为格式化字符串
     * 
     * @param date 时间
     * @param format 格式化样式
     * @return 格式化字符串，如果失败返回为null
     */
    public static String date2String(Date date, String format) {
        String dateStr = null;
        try {
            if (date != null) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                dateStr = simpleDateFormat.format(date);
                simpleDateFormat.parse(dateStr);
            }
        } catch (Exception ex) {
            System.err.println("date to string failure. The detail information is: " + ex);
        }
        return dateStr;
    }

    /**
     * 时间类型转化为格式化字符串
     * 
     * @param date 时间
     * @param format 格式化样式
     * @return 格式化字符串，如果失败返回为null
     * @throws Exception 
     */
    public static Date string2Date(String dateStr, String format) {
        Date date = null;
        try {
            if (dateStr == null || dateStr.length() == 0) {
                return date;
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            date = simpleDateFormat.parse(dateStr);
        } catch (Exception ex) {
            System.err.println("date to string failure. The detail information is: " + ex);
            throw new RuntimeException(ex);
        }
        return date;
    }

    /**
     * 比较date2是否大于或者等于date1
     * 
     * @param date1 时间
     * @param date2 时间
     * @return
     */
    public static boolean isBiger(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            return false;
        }
        Long b = date1.getTime();
        Long e = date2.getTime();
        return e >= b;
    }

    /**
     * 计算两个时间相差的月份，从1开始，两个时间相同则相差月份为1
     * <p>
     * 在最大值内返回两个时间相差的月份，如果相差的时间大于这个最大值则返回最大值;
     * </p>
     * <li>相差的月份大于等于0</li> <li>相差的月份小于等于最大值differ</li>
     * 
     * @param sdate 开始时间 （不能为空）
     * @param differ 最大相差值 （不能为空，大于0）
     * @param ldate 结束时间 （不能为空）
     * @return
     */
    public static Integer differMonth(Date sdate, Integer differ, Date ldate) {

        //开始时间

        Calendar sCal = Calendar.getInstance();
        sCal.setTime(sdate);
        sCal.set(Calendar.HOUR_OF_DAY, 0);
        sCal.set(Calendar.MINUTE, 0);
        sCal.set(Calendar.SECOND, 0);

        //结束时间
        Calendar lCal = Calendar.getInstance();
        lCal.setTime(ldate);
        lCal.set(Calendar.HOUR_OF_DAY, 0);
        lCal.set(Calendar.MINUTE, 0);
        lCal.set(Calendar.SECOND, 0);

        if (lCal.compareTo(sCal) < 0) {
            return 0;
        }
        //比较时间
        Calendar temp = sCal;
        for (int i = 1; i <= differ; i++) {
            temp.add(Calendar.MONTH, 1);
            temp.add(Calendar.DATE, -1);
            if (lCal.compareTo(temp) <= 0) {
                return i;
            }
            temp.add(Calendar.DATE, 1);
        }
        return differ;
    }

    /**
     * 判断两个日期之间相差多少天（忽略时分秒）
     * @param firstDate 第一个指定的日期
     * @param anotherDate 第二个指定的日期
     * @return 相差的天数
     */
    public static int minusWithDay(Date firstDate, Date anotherDate) {
        long first = DateUtils.truncate(firstDate, Calendar.DAY_OF_MONTH).getTime();
        long another = DateUtils.truncate(anotherDate, Calendar.DAY_OF_MONTH).getTime();
        return (int) ((first - another) / (24 * 60 * 60 * 1000));
    }

    /**
     * 获取当天时间，时间精度为天
     * <li>
     * 例如输入2013-09-09 23:59:59会返回2013-09-09 00:00:00
     * @param date 设置时间
     */
    public static Date formatDay(Date date) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * 给指定日期加间隔毫秒
     * @param startDate
     * @param intervalSecond
     * @return
     */
    public static Date addIntervalSecond(Date startDate, long intervalSecond) {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        calendar.setTimeInMillis(startDate.getTime() + intervalSecond);
        return calendar.getTime();
    }

    /**
     * 得到今天开始时间
     * @return
     */
    public static Date getMorning() {
        Calendar rightNow = Calendar.getInstance();
        rightNow.set(Calendar.DATE, rightNow.get(Calendar.DATE));
        rightNow.set(Calendar.HOUR_OF_DAY, 0);
        rightNow.set(Calendar.MINUTE, 0);
        rightNow.set(Calendar.SECOND, 0);
        rightNow.set(Calendar.MILLISECOND, 0);
        return rightNow.getTime();
    }

    /**
     * 获得当前时间
     * @return
     */
    public static Date getCurrentTime() {
        Calendar rightNow = Calendar.getInstance();
        return rightNow.getTime();
    }

    /**
     * 得到制定日期的前n天
     * @param date
     * @param n
     * @return
     */
    public static Date getDayBefore(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -1 * n);
        return cal.getTime();
    }

    /**
     * 得到前n个月的最后一天
     * @param date
     * @param n
     * @return
     */
    public static Date getBeforeMonthDate(Date date, int n) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, -1 * n);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * 得到所在月的最后一天，如果在当前月，则返回当前时间的前一天
     * @param date
     * @return
     */
    public static Date getLastDayInMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        Calendar dateCal = Calendar.getInstance();
        if (date.compareTo(getCurrentTime()) >= 0) {
            return getDayBefore(getCurrentTime(), 1);
        }
        dateCal.setTime(date);
        if (cal.get(Calendar.YEAR) == dateCal.get(Calendar.YEAR)
            && cal.get(Calendar.MONTH) == dateCal.get(Calendar.MONTH)) {
            return getDayBefore(getCurrentTime(), 1);
        } else {
            dateCal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
            return dateCal.getTime();
        }
    }

    /**
     * 判断两个日期是否在同一个月份
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);

        return cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
               && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
    }

    public static String format(Date date, String format) {
        SimpleDateFormat formate = new SimpleDateFormat(format);
        return formate.format(date);
    }

    public static String format(Date date) {
        SimpleDateFormat formate = new SimpleDateFormat(TIME_FORMAT_F);
        return formate.format(date);
    }

    public static Date parse(String date) {
        return parse(date, parseDatePatterns);
    }

    public static Date parse(String date, String format) {
        return parse(date, new String[] { format });
    }

    public static Date parse(String date, String[] formats) {
        try {
            return DateUtils.parseDate(date, formats);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }
}
