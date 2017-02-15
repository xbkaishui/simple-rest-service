package tbdp.dao;

import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public interface ModConfigDAO {

    ModConfig selectById(long id) throws SQLException;

    List<ModConfig> selectByParam(ModelConfigQueryParam param) throws SQLException;

    public void deleteById(long id) throws SQLException;

    public Long insert(ModConfig mod) throws SQLException;

    public void update(ModConfig mod) throws SQLException;

}
