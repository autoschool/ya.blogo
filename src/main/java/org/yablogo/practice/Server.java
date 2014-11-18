package org.yablogo.practice;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.mvc.freemarker.FreemarkerMvcFeature;
import org.yablogo.practice.service.DatabaseProvider;

import javax.ws.rs.container.DynamicFeature;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.FeatureContext;

/**
 * Server class.
 *
 */
public class Server extends ResourceConfig {

    public Server() {
        register(FreemarkerMvcFeature.class);

        register(new DynamicFeature() {
            @Override
            public void configure(ResourceInfo resourceInfo, FeatureContext context) {
                context.register(DatabaseProvider.class);
            }
        });

        packages(Server.class.getPackage().getName());
    }
}






