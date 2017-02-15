package tbdp.common.result;

import tbdp.common.Result;
import tbdp.model.ModConfig;

import java.util.List;

/**
 * Created by xbkaishui on 17/2/14.
 */
public class ModelResult extends Result {

    private List<ModConfig> data;

    public List<ModConfig> getData() {
        return data;
    }

    public void setData(List<ModConfig> data) {
        this.data = data;
    }
}
