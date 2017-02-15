package tbdp;

import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.logging.LoggingFeature;
import org.glassfish.jersey.message.filtering.EntityFilteringFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.filter.HttpMethodOverrideFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.glassfish.jersey.server.mvc.beanvalidation.MvcBeanValidationFeature;
import tbdp.providers.CORSResponseFilter;

import javax.ws.rs.ApplicationPath;
import java.util.logging.Logger;

/**
 * Created by xbkaishui on 17/2/13.
 */
@ApplicationPath("api")
public class AppRoot extends ResourceConfig {
    private static Logger LOGGER = Logger.getLogger(AppRoot.class.getSimpleName());
    public AppRoot() {
        // logging
//        registerInstances(new LoggingFeature(LOGGER, LoggingFeature.Verbosity.PAYLOAD_ANY));

        // Select packages to scan for resources and providers
        packages("tbdp.resources","com.example",
            "tbdp.providers");

        // configure MOXy providers
        // XML
//        register(MoxyXmlFeature.class);
//        property(MessageProperties.XML_FORMAT_OUTPUT, true);
        // JSON
//        register(MoxyJsonFeature.class);
//        register(createMoxyJsonResolver());
        register(JacksonFeature.class);

        // Enable on-demand tracing
        property(ServerProperties.TRACING, "ON_DEMAND");

        // Enable monitoring MBeans
        property(ServerProperties.MONITORING_STATISTICS_MBEANS_ENABLED, true);

        // Support for HTTP method override via query parameter
        register(new HttpMethodOverrideFilter(HttpMethodOverrideFilter.Source.QUERY));

        // Propagate validation errors to client
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);

        // Enable support for role-based authorization
        register(RolesAllowedDynamicFeature.class);

        // Enable JSON entity filtering
        register(EntityFilteringFeature.class);

        // Enable MVC FreeMarker templating engine
        register(MvcBeanValidationFeature.class);

        //CORS support
        register(CORSResponseFilter.class);
        // Enable SSE support
//        register(SseFeature.class);
    }

//    /**
//     * Create {@link ContextResolver} for {@link MoxyJsonConfig} for this application.
//     *
//     * @return {@code MoxyJsonConfig} context resolver.
//     */
//    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
//        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig()
//            .setFormattedOutput(true)
//            .setNamespaceSeparator(':');
//        return moxyJsonConfig.resolver();
//    }
}
