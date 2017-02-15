package tbdp.dao.ibatis;

import tbdp.dao.BaseDaoTemplate;
import tbdp.dao.ModConfigDAO;
import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class ModelConfigIbatisDAOImpl extends BaseDaoTemplate implements ModConfigDAO {

    public ModConfig selectById(long id) throws SQLException {
        return (ModConfig) sqlMapClient.queryForObject("ModConfig.selectById", id);
    }

    public List<ModConfig> selectByParam(ModelConfigQueryParam param) throws SQLException {
        return sqlMapClient.queryForList("ModConfig.selectByParam", param);
    }

    public void deleteById(long id) throws SQLException {
        sqlMapClient.delete("ModConfig.delete",id);
    }

    public Long insert(ModConfig mod) throws SQLException {
       return (Long) sqlMapClient.insert("ModConfig.insert", mod);
    }

    public void update(ModConfig mod) throws SQLException {
        sqlMapClient.update("ModConfig.update", mod);
    }
}
