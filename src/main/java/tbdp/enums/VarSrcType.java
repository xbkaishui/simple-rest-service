package tbdp.enums;

/**
 * Created by xbkaishui on 16/12/24.
 * 源类型
 */
public enum VarSrcType {

    kafka, mysql, hive;

    public static VarSrcType getSrcType(String type) {
        type = type.toLowerCase();
        return VarSrcType.valueOf(type);
    }

}
