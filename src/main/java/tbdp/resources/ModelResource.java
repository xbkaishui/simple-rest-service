package tbdp.resources;

import tbdp.common.Result;
import tbdp.common.result.ModelResult;
import tbdp.model.ModConfig;
import tbdp.param.ModelConfigQueryParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/14.
 */
@Path("/models")
public class ModelResource extends BaseResource {

    @GET @Produces(MediaType.APPLICATION_JSON) public ModelResult getAllModels() {
        ModelResult result = new ModelResult();
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

    @DELETE @Path("{id}") @Produces(MediaType.APPLICATION_JSON)
    public Result deleteModel(@PathParam("id") String modId) {
        Result result = new Result();
        try {
            modelDAO.deleteById(Long.parseLong(modId));
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e);
        }
        return result;
    }

    @PUT @Path("{id}") @Produces(MediaType.APPLICATION_JSON)
    public Result updateModel(@PathParam("id") String modId, ModConfig modConfig) {
        Result result = new Result();
        try {
            modelDAO.update(modConfig);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e);
        }
        return result;
    }

    @POST @Produces(MediaType.APPLICATION_JSON) public Result addModel(ModConfig modConfig) {
        Result result = new Result();
        try {
            modelDAO.insert(modConfig);
            result.setSuccess(true);
        } catch (Exception e) {
            result.setSuccess(false);
            logger.error(e);
        }
        return result;
    }

}
