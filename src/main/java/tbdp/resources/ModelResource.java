package tbdp.resources;

import org.apache.log4j.Logger;
import tbdp.common.Result;
import tbdp.model.Employees;
import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/14.
 */
@Path("/models") public class ModelResource extends BaseResource {

    @GET @Produces(MediaType.APPLICATION_JSON) public Result getAllModels() {
        Result<List<ModConfig>> result = null;
        ModelConfigQueryParam param = new ModelConfigQueryParam();
        try {
            List<ModConfig> models = modelDAO.selectByParam(param);
            result = new Result<>(models);
        } catch (SQLException e) {
            result = new Result<>().setSuccess(false);
            logger.error(e);
        }
        return result;
    }


}
