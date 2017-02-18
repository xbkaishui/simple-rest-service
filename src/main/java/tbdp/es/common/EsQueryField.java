package tbdp.es.common;

import tbdp.common.ToString;

/**
 * Created by xbkaishui on 17/2/18.
 */
public class EsQueryField extends ToString {

    private String name;
    private Object value;
    private Operator operator;

    public EsQueryField(String name) {
        this.name = name;
    }

    public EsQueryField(String name, Object value, Operator operator) {
        this.name = name;
        this.value = value;
        this.operator = operator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
