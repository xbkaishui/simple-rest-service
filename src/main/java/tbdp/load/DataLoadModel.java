package tbdp.load;

import tbdp.common.ToString;
import tbdp.enums.VarSrcType;
import tbdp.model.Model;
import tbdp.model.Vari;

import java.util.List;
import java.util.Map;

/**
 * Created by xbkaishui on 16/12/25.
 */
public class DataLoadModel extends ToString{

    private List<Model> models;

    private Map<VarSrcType, List<Vari>> varSrcTypesMap;

    public List<Model> getModels() {
        return models;
    }

    public void setModels(List<Model> models) {
        this.models = models;
    }

    public Map<VarSrcType, List<Vari>> getVarSrcTypesMap() {
        return varSrcTypesMap;
    }

    public void setVarSrcTypesMap(Map<VarSrcType, List<Vari>> varSrcTypesMap) {
        this.varSrcTypesMap = varSrcTypesMap;
    }
}
