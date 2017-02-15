package tbdp.resources;

import org.apache.log4j.Logger;
import tbdp.common.Result;
import tbdp.common.result.ModelResult;
import tbdp.model.Employees;
import tbdp.model.ModConfig;
import tbdp.model.Models;
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

    @GET @Produces(MediaType.APPLICATION_JSON) public ModelResult getAllModels() {
        ModelResult result = new ModelResult();
        ;
        ModelConfigQueryParam param = new ModelConfigQueryParam();
        try {
            List<ModConfig> models = modelDAO.selectByParam(param);
            result.setData(models);
        } catch (SQLException e) {
            result.setSuccess(false);
            logger.error(e);
        }
        return result;
    }

    @GET @Path("rr") @Produces(MediaType.APPLICATION_JSON) public Models getAllModelsRR() {
        ModelConfigQueryParam param = new ModelConfigQueryParam();
        Models models1 = new Models();
        try {
            List<ModConfig> models = modelDAO.selectByParam(param);
            models1.setModels(models);
        } catch (SQLException e) {
            logger.error(e);
        }
        return models1;
    }

    //    @GET
    //    @Path("rrs")
    //    @Produces(MediaType.APPLICATION_JSON) public Result getAllModelsRRs() {
    //        ModelConfigQueryParam param = new ModelConfigQueryParam();
    //        Models models1 = new Models();
    //        try {
    //            List<ModConfig> models = modelDAO.selectByParam(param);
    //            models1.setModels(models);
    //        } catch (SQLException e) {
    //            logger.error(e);
    //        }
    //        return new Result(models1);
    //    }


}
