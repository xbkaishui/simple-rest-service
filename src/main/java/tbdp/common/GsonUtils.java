package tbdp.common;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by xbkaishui on 16/12/25.
 */
public class GsonUtils {
    private static final Gson gson =
        new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();

    public static Map<String, String> toMap(String content) {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> rs = gson.fromJson(content, type);
        return rs;
    }

    public String toString(Object obj) {
        return gson.toJson(obj);
    }

    public static Gson getGson() {
        return gson;
    }
}
