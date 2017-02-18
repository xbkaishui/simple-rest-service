package tbdp.es.domain;

import tbdp.common.ToString;

import java.util.List;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class ModelQueryResult extends ToString {

    private List<Model> models ;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }
}
