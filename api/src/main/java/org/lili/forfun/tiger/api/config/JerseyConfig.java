package org.lili.forfun.tiger.api.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.lili.forfun.tiger.api.TigerApi;
import org.lili.forfun.tiger.api.TigerOpsApi;
import org.lili.forfun.tiger.api.provider.TigerReadProvider;
import org.springframework.stereotype.Component;


@Component
public class JerseyConfig extends ResourceConfig {
    public JerseyConfig() {
        this.registerEndpoints();
        this.registerProviders();
    }

    private void registerEndpoints() {
        this.register(TigerApi.class);
        this.register(TigerOpsApi.class);
        this.register(WadlResource.class);
    }

    private void registerProviders() {
        this.register(TigerReadProvider.class);
    }
}
