package tbdp.es.service;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsSqlClientTest {

    @Test public void testQuery() throws Exception {
        EsSqlClient client = EsSqlClient.instance();
        client.query("select user , message from twitter limit 10 ");
    }

    @Test public void testQueryWithColumn() throws Exception {
        EsSqlClient client = EsSqlClient.instance();
        List<Map<String, String>> data =
            client.query("select user , message from twitter limit 10 ", "user", "message");
        System.out.println(data);

    }
}
