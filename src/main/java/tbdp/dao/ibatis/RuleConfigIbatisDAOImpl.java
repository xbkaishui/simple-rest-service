package tbdp.dao.ibatis;

import tbdp.dao.BaseDaoTemplate;
import tbdp.dao.ModConfigDAO;
import tbdp.dao.RuleConfigDAO;
import tbdp.model.ModConfig;
import tbdp.model.RuleConfig;
import tbdp.param.ModelConfigQueryParam;
import tbdp.param.RuleConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleConfigIbatisDAOImpl extends BaseDaoTemplate implements RuleConfigDAO {

    public RuleConfig selectById(Long id) throws SQLException {
        return (RuleConfig) sqlMapClient.queryForObject("RuleConfig.selectById", id);
    }

    public List<RuleConfig> selectByParam(RuleConfigQueryParam param) throws SQLException {
        return sqlMapClient.queryForList("RuleConfig.selectByParam", param);
    }
}
