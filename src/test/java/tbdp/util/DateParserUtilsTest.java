package tbdp.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 16-12-24.
 */
public class DateParserUtilsTest {
    @Test
    public void processDateFormat() throws Exception {
        String dateFormat = "dt=${yyyymmdd-1}";
        String date = "20161220";
        String expect = "dt=20161219";
//        dateFormat = "tdate<=${yyyymmdd}";
        Assert.assertEquals(expect, DateParserUtils.processDateFormat(dateFormat, date));

        System.out.println( DateParserUtils.processDateFormat("${9}", date));
    }

}
