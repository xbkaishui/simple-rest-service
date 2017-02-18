package tbdp.load;

import org.junit.Test;
import tbdp.model.Model;
import tbdp.param.ModelQueryParam;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class ESModelQueryLoadTest {

    @Test public void testQueryModels() throws Exception {
        ESModelQueryLoad load = new ESModelQueryLoad();
        ModelQueryParam param = new ModelQueryParam();
        param.setMid("2");
        param.setRuleId("13");
        //ruleID=7
        //ruleID=13
        List<Model> models = load.queryModels(param);
        System.out.println(models);
    }

    @Test public void testSubstr() {
        long ruleId = 13l;
        String content = "${1} <= LimitUpDays_BT <= ${2}";
        try {
            String result = ESModelQueryLoad.substituteVars(content, ruleId);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}
