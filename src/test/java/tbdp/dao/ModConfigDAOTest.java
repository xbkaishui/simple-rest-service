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

    @Test public void testInsert() throws SQLException {
        ModConfig config = new ModConfig();
        config.setModName("test");
        config.setModPriority(1);
        config.setModType(1);
        config.setModDesc("test desc");
        config.setUserID("xb");
        config.setStatus(1);
        long id = modConfigDAO.insert(config);
        System.out.println("create model Id " + id);
        Assert.assertTrue(id > 0);
    }

    @Test public void testUpdate() throws SQLException {
        ModConfig config = new ModConfig();
        config.setModId(97l);
        config.setModDesc("test desc update");
        modConfigDAO.update(config);
        ModConfig configNew = modConfigDAO.selectById(97l);
        Assert.assertEquals(configNew.getModDesc(),"test desc update");
    }

    @Test public void testDelete() throws SQLException {
        modConfigDAO.deleteById(98l);
    }

    @Test public void testSelectByParam() throws SQLException {
        ModelConfigQueryParam param = new ModelConfigQueryParam();
        param.setStatus(1);
        List<ModConfig> configs = modConfigDAO.selectByParam(param);
        Assert.assertTrue(configs.size() > 1);
    }
}
