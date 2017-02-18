package tbdp.es.domain;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class Model extends ToString {

    private String scode;
    private String marketType;

    public String getScode() {
        return scode;
    }

    public void setScode(String scode) {
        this.scode = scode;
    }

    public String getMarketType() {
        return marketType;
    }

    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
}
