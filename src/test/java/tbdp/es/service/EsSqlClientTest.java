package tbdp.es.service;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsSqlClientTest {

    @Test public void testQuery() throws Exception {
        EsSqlClient client = EsSqlClient.instance();
        client.query("select user , message from twitter limit 10 ");
    }
}
