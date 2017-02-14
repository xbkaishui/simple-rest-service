package tbdp.resources;

import org.apache.log4j.Logger;
import tbdp.dao.ModConfigDAO;
import tbdp.dao.RuleConfigDAO;
import tbdp.dao.RuleModRelaDAO;
import tbdp.dao.VariConfigDAO;
import tbdp.dao.ibatis.ModelConfigIbatisDAOImpl;
import tbdp.dao.ibatis.RuleConfigIbatisDAOImpl;
import tbdp.dao.ibatis.RuleModRelaIbatisDAOImpl;
import tbdp.dao.ibatis.VariConfigIbatisDAOImpl;

/**
 * Created by xbkaishui on 17/2/14.
 */
public class BaseResource {

    protected static ModConfigDAO modelDAO = new ModelConfigIbatisDAOImpl();
    protected static VariConfigDAO variDAO = new VariConfigIbatisDAOImpl();
    protected static RuleConfigDAO ruleDAO = new RuleConfigIbatisDAOImpl();
    protected static RuleModRelaDAO ruleModRelaDAO = new RuleModRelaIbatisDAOImpl();

    protected static final Logger logger = Logger.getLogger(BaseResource.class);

}
