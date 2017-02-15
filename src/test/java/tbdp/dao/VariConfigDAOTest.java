package tbdp.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tbdp.dao.ibatis.VariConfigIbatisDAOImpl;
import tbdp.model.VariConfig;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class VariConfigDAOTest {

    private static VariConfigDAO variConfigDAO;

    @BeforeClass public static void init() {
        variConfigDAO = new VariConfigIbatisDAOImpl();
    }

    @Test public void testSelectByVarCode() throws Exception {
        String variCode = "VOL";
        VariConfig config = variConfigDAO.selectByVarCode(variCode);
        Assert.assertNotNull(config);
    }

    @Test public void testSelectById() throws Exception {
        long id = 40;
        VariConfig config = variConfigDAO.selectById(id);
        Assert.assertNotNull(config);
    }
}
