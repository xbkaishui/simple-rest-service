package tbdp.model;

import org.apache.commons.lang.StringUtils;
import tbdp.common.ToString;

/**
 * Created by xbkaishui on 16/12/25.
 * 指标来源
 */
public class VarSourceModel extends ToString {

    private final static String EMPTY = "";

    //类型 mysql /hive /kafka /hbase /file
    private String type;

    private String schema;
    //table 可能为多个
    private String table;
    private String condition;
    //原始来源字段
    private String source;

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /**
     * 解析来源字段 根据 : 分割 schema 和 table
     *
     * @param src
     * @return
     */
    public static VarSourceModel parse(String src) {
        VarSourceModel model = new VarSourceModel();
        String[] pair = src.split(":");
        if (pair.length == 2) {
            model.type = pair[0];
            model.schema = EMPTY;
            model.table = pair[1];
        } else {
            model.type = pair[0];
            model.schema = pair[1];
            model.table = pair[2];
        }
        return model;
    }

    /**
     * 获取默认schema 如果schmea没有填写则为对应的表
     *
     * @return
     */
    public String getSchemaWithDefault() {
        if (StringUtils.equalsIgnoreCase(schema, EMPTY)) {
            return table;
        } else {
            return schema;
        }
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        VarSourceModel that = (VarSourceModel) o;

        if (schema != null ? !schema.equals(that.schema) : that.schema != null)
            return false;
        return table != null ? table.equals(that.table) : that.table == null;
    }

    @Override public int hashCode() {
        int result = schema != null ? schema.hashCode() : 0;
        result = 31 * result + (table != null ? table.hashCode() : 0);
        return result;
    }
}
