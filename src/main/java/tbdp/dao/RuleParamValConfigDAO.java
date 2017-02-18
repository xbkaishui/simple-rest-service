package tbdp.dao;

import tbdp.model.RuleParamValConfig;
import tbdp.param.RuleParamValQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/18.
 */
public interface RuleParamValConfigDAO {

    List<RuleParamValConfig> selectByParam(RuleParamValQueryParam param) throws SQLException;

    void update(RuleParamValConfig config) throws SQLException;

}
