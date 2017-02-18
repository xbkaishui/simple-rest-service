package tbdp.dao.ibatis;

import tbdp.dao.BaseDaoTemplate;
import tbdp.dao.RuleParamValConfigDAO;
import tbdp.model.RuleParamValConfig;
import tbdp.param.RuleParamValQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class RuleParamValConfigIbatisDAOImpl extends BaseDaoTemplate implements RuleParamValConfigDAO {
    @Override public List<RuleParamValConfig> selectByParam(RuleParamValQueryParam param)
        throws SQLException {
        return sqlMapClient.queryForList("RuleParamValConfig.selectByParam",param);
    }

    @Override public void update(RuleParamValConfig config) {

    }
}
