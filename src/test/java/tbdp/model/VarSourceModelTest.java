package tbdp.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 16/12/27.
 */
public class VarSourceModelTest {

    @Test public void testParse() throws Exception {
        String variSrc = "hive:tbdp:KLine_Day";
        VarSourceModel sourceModel = VarSourceModel.parse(variSrc);
        System.out.println(sourceModel);

        variSrc = "kafka:topic.out.TimeLine_SH,topic.out.TimeLine_SZ";
        sourceModel = VarSourceModel.parse(variSrc);
        System.out.println(sourceModel);

    }
}
