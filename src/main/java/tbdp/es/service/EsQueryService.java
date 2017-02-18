package tbdp.es.service;

import tbdp.es.domain.ModelQueryResult;
import tbdp.load.ESModelQueryLoad;
import tbdp.model.Model;
import tbdp.param.ModelQueryParam;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsQueryService {

    private static final ESModelQueryLoad queryLoad = new ESModelQueryLoad();

    public ModelQueryResult queryModel(ModelQueryParam queryParam) {
        ModelQueryResult result = new ModelQueryResult();
        List<tbdp.es.domain.Model> esModels = new LinkedList<>();
        List<Model> models = queryLoad.queryModels(queryParam);
        //调用 es 接口查询数据
        for (Model model : models) {
            List<tbdp.es.domain.Model> returnModels = queryEsEngine(model);
            esModels.addAll(returnModels);
        }
        result.setModels(esModels);
        return result;
    }

    private List<tbdp.es.domain.Model> queryEsEngine(Model model) {
        return null;
    }

}
