package tbdp.dao;

import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public interface ModConfigDAO {

    ModConfig selectById(long id ) throws SQLException;

    List<ModConfig> selectByParam(ModelConfigQueryParam param) throws SQLException ;

}
