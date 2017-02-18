package tbdp.es.common;

import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class ExpressionUtilsTest {

    @Test public void testParseRuleContext() throws Exception {
        String exp = "12 > IPODates_BT >=3";
        System.out.println(exp);
        List<EsQueryField> fields = ExpressionUtils.parseRuleContext(exp);
        System.out.println(fields);
        Assert.assertTrue(fields.size() == 2);
    }

    @Test public void testParseRuleContext2() throws Exception {
        String exp = "IPODates_BT >=3";
        System.out.println(exp);
        List<EsQueryField> fields = ExpressionUtils.parseRuleContext(exp);
        System.out.println(fields);
        Assert.assertTrue(fields.size() == 1);
    }
}
