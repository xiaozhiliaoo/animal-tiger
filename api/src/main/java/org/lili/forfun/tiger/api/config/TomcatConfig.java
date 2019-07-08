package org.lili.forfun.tiger.api.config;

import lombok.Data;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@ConfigurationProperties(prefix = "tom")
@Data
public class TomcatConfig {
    private int maxConnections;
    private int maxThreads;
    private int soTimeout;

    @Bean
    public TomcatServletWebServerFactory servletContainer() {
        TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();
        tomcatFactory.addConnectorCustomizers((TomcatConnectorCustomizer)connector -> {
            Http11NioProtocol protocol = (Http11NioProtocol)connector.getProtocolHandler();
            protocol.setMaxConnections(getMaxConnections());
            protocol.setMaxThreads(getMaxThreads());
            protocol.setConnectionTimeout(getSoTimeout());
        });
        return tomcatFactory;
    }
}
