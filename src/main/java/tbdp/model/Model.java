package tbdp.model;

import tbdp.common.ToString;
import tbdp.enums.ModType;

import java.util.List;

/**
 * 模型实体类
 * Created by xbkaishui on 16/12/18.
 */
public class Model extends ToString {

    private ModConfig modConfig;

    private ModType modType;

    private List<Rule> rules;

    public ModConfig getModConfig() {
        return modConfig;
    }

    public void setModConfig(ModConfig modConfig) {
        this.modConfig = modConfig;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    public ModType getModType() {
        return modType;
    }

    public void setModType(ModType modType) {
        this.modType = modType;
    }
}
