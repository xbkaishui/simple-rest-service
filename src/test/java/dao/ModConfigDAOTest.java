package tbdp.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import tbdp.dao.ibatis.ModelConfigIbatisDAOImpl;
import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class ModConfigDAOTest {

    protected static ModConfigDAO modConfigDAO;

    @BeforeClass public static void init() {
        modConfigDAO = new ModelConfigIbatisDAOImpl();
    }

    @Test public void testSelectById() throws SQLException {
        ModConfig config = modConfigDAO.selectById(1l);
        Assert.assertNotNull(config);
    }

    @Test public void testSelectByParam() throws SQLException {
        ModelConfigQueryParam param = new ModelConfigQueryParam();
        param.setStatus(1);
        List<ModConfig> configs = modConfigDAO.selectByParam(param);
        Assert.assertTrue(configs.size() > 1);
    }
}
