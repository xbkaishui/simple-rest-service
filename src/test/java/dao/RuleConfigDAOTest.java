package tbdp.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tbdp.dao.ibatis.ModelConfigIbatisDAOImpl;
import tbdp.dao.ibatis.RuleConfigIbatisDAOImpl;
import tbdp.model.RuleConfig;

import static org.junit.Assert.*;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleConfigDAOTest {

    protected static RuleConfigDAO ruleConfigDAO;

    @BeforeClass public static void init() {
        ruleConfigDAO = new RuleConfigIbatisDAOImpl();
    }

    @Test public void testSelectById() throws Exception {
        RuleConfig config = ruleConfigDAO.selectById(1l);
        Assert.assertNotNull(config);
    }

    @Test public void testSelectByParam() throws Exception {

    }
}
