package tbdp.util;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * 时间日期格式化
 * @author xbkaishui
 * @version $Id: DateFormatUtils.java, v 0.1 2015-11-25 下午4:24:11 xbkaishui Exp $
 */
public class DateParserUtils {

    private static Pattern dateVarPattern    = Pattern
            .compile("\\$\\{([isymdhYMHD0-9.,:\\/\\=_\\-\\+\\*\\ ]+)\\}");

    private static Pattern seqDateVarPattern = Pattern
            .compile("(([\\w]+\\s?=)?\\s*\'?\\$\\{([isymdhYMHD0-9.,:\\/\\*\\=_\\-\\+\\ ]+)\\}[\\d]*\')\\s*~\\s*(([\\w]+\\s?=)?\\s*\'?\\$\\{([isymdhYMHD0-9.,:\\/\\=_\\-\\*\\+\\ ]+)\\}[\\d]*\'\\s*?)");

    private static Pattern dateOffsetPattern = Pattern.compile("([\\+\\-]{1})([\\s\\d\\/\\*]+)");

    /**
     * 解析日期格式 前置判断 如果为空 则返回
     * @param str
     * @param date
     * @return
     */
    public static String processDateFormat(String str, String date) {
        if(StringUtils.isEmpty(str)){
            return str ;
        }
        //日期匹配
        Matcher matcher = dateVarPattern.matcher(str.toString());
        while (matcher.find()) {
            String rangeFormat = matcher.group(1);
            //如果匹配为数字 则直接返回
            if(NumberUtils.isNumber(rangeFormat)){
                return str;
            }
            String rs = renderDate(rangeFormat, date);
            if (StringUtils.isNotEmpty(rs)) {
                String next = matcher.replaceFirst(rs);
                return processDateFormat(next, date);
            }
        }
        return str;
    }

    public static String processSeqFormat(String str, String date) {
        Matcher matcher = seqDateVarPattern.matcher(str.toString());
        while (matcher.find()) {
            String rangeFormat = matcher.group();
//            System.out.println(rangeFormat);
            String rs = renderSeqDate(rangeFormat, date);
            if (StringUtils.isNotEmpty(rs)) {
                String next = matcher.replaceFirst(rs);
                return processSeqFormat(next, date);
            }
        }
        return str;
    }

    /**
     *
     * @param rangeFormat
     * @param date
     * @return
     */
    private static String renderSeqDate(String rangeFormat, String date) {
        return null;
    }

    /**
     *
     * @param dateFormat
     * @param date
     * @return
     */
    public static String renderDate(String dateFormat, String date) {
        Date formatDate = DateFormatUtil.parse(date);
        Matcher numMatcher = dateOffsetPattern.matcher(dateFormat);
        if (numMatcher.find()) {
            String num = numMatcher.group().trim();
//            System.out.println("num group " + num);
            String oper = numMatcher.group(1).trim();
            String offset = numMatcher.group(2).trim();
            Operator operator = Operator.getOperator(oper);
            DateType dateType = DateType.parse(dateFormat);
            int amount = parseAmout(offset);
            formatDate = operator.apply(formatDate, dateType, amount);
            dateFormat = dateFormat.substring(0, dateFormat.length() - num.length());
        }else{
//            return dateFormat;
        }
        //compitable dxp format
        String cdf = dateFormat.trim().replace("mm", "MM").replace("hh24", "HH")
                .replace("mi", "mm");
        String dt = DateFormatUtil.format(formatDate, cdf);
        return dt;
    }

    /**
     *
     * @param offset
     * @return
     */
    private static int parseAmout(String offset) {
        //check if time flag
        if (offset.indexOf("/") > -1) {
            String[] mins = offset.split("/");
            int start = 24 * 60;
            int idx = 0;
            for (String min : mins) {
                if (idx == 0) {
                    start *= Integer.valueOf(min.trim());
                } else {
                    start /= Integer.valueOf(min.trim());
                }
                idx++;

            }
            return start;
        }
        return Integer.valueOf(offset);
    }



}
