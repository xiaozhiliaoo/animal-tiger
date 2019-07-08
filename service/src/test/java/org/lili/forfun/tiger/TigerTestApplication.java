package org.lili.forfun.tiger;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication(scanBasePackages = {"org.lili.forfun"})
@PropertySources({
    @PropertySource("file:/opt/tiger/tiger.properties"),
    @PropertySource("file:/opt/tiger/tiger-common.properties"),
})
public class TigerTestApplication {

}