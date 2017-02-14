package tbdp.dao;

import tbdp.model.RuleModRela;
import tbdp.model.VariConfig;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 16/12/18.
 */
public interface VariConfigDAO {

    public VariConfig selectByVarCode(String code) throws SQLException;

    public VariConfig selectById(Long id) throws SQLException;

}
