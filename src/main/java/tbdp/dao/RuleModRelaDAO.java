package tbdp.dao;

import tbdp.model.RuleModRela;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public interface RuleModRelaDAO {
    public List<RuleModRela> selectByModId(Long id) throws SQLException;
}
