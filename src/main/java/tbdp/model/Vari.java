package tbdp.model;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 16-12-22.
 */
public class Vari extends ToString {

    private VariConfig config;

    private VarSourceModel sourceModel;

    public VarSourceModel getSourceModel() {
        return sourceModel;
    }

    public void setSourceModel(VarSourceModel sourceModel) {
        this.sourceModel = sourceModel;
    }

    public VariConfig getConfig() {
        return config;
    }

    public void setConfig(VariConfig config) {
        this.config = config;
    }
}
