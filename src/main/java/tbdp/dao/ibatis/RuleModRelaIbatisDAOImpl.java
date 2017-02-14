package tbdp.dao.ibatis;

import tbdp.dao.BaseDaoTemplate;
import tbdp.dao.RuleModRelaDAO;
import tbdp.model.RuleModRela;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public class RuleModRelaIbatisDAOImpl extends BaseDaoTemplate implements RuleModRelaDAO {
    public List<RuleModRela> selectByModId(Long id) throws SQLException {
        return sqlMapClient.queryForList("RuleModRela.selectByModId", id);
    }
}
