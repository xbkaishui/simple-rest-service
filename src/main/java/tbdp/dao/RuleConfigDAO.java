package tbdp.dao;

import tbdp.model.RuleConfig;
import tbdp.param.RuleConfigQueryParam;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public interface RuleConfigDAO {

    RuleConfig selectById(Long id) throws SQLException;

    List<RuleConfig> selectByParam(RuleConfigQueryParam param) throws SQLException;
}
