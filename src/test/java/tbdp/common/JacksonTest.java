package tbdp.common;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import org.junit.Test;
import tbdp.common.result.ModelResult;
import tbdp.model.ModConfig;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xbkaishui on 17/2/14.
 */
public class JacksonTest {

    private static AnnotationIntrospector createJaxbJacksonAnnotationIntrospector() {
        //
        final AnnotationIntrospector jaxbIntrospector =
            new JaxbAnnotationIntrospector(TypeFactory.defaultInstance());
        final AnnotationIntrospector jacksonIntrospector = new JacksonAnnotationIntrospector();

        return AnnotationIntrospector.pair(jacksonIntrospector, jaxbIntrospector);
    }

    @Test public void testToJson() {
        ObjectMapper mapper =
            new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, true)
                .configure(DeserializationFeature.UNWRAP_ROOT_VALUE, true)
                .setAnnotationIntrospector(createJaxbJacksonAnnotationIntrospector());
        List<ModConfig> configList = new ArrayList<>();
        ModConfig mc1 = new ModConfig();
        mc1.setModId(1l);
        configList.add(mc1);

        ModConfig mc2 = new ModConfig();
        mc2.setModId(1l);
        configList.add(mc2);

        ModelResult result = new ModelResult();
        result.setData(configList);
        try {
            String jsonInString = mapper.writeValueAsString(result);
            System.out.println(jsonInString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
