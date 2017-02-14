package tbdp.dao.ibatis;

import tbdp.dao.BaseDaoTemplate;
import tbdp.dao.VariConfigDAO;
import tbdp.model.VariConfig;

import java.sql.SQLException;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class VariConfigIbatisDAOImpl extends BaseDaoTemplate implements VariConfigDAO {

    public VariConfig selectByVarCode(String code) throws SQLException {
        return (VariConfig) sqlMapClient.queryForObject("VariConfig.selectByVarCode", code);
    }

    public VariConfig selectById(Long id) throws SQLException {
        return (VariConfig) sqlMapClient.queryForObject("VariConfig.selectById", id);
    }

}
