package org.lili.forfun.tiger;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.infra.domain.config.FileConfig;
import org.lili.forfun.infra.engine.message.MqProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@SpringBootApplication
//@PropertySources({
//    @PropertySource("file:/opt/tiger/tiger.properties"),
//    @PropertySource("file:/opt/tiger/tiger-common.properties"),
//})
@PropertySources({
    @PropertySource("classpath:tiger.properties"),
    @PropertySource("classpath:tiger-common.properties"),
})
@ComponentScan(basePackages = {"org.lili.forfun"},
        excludeFilters =
                {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,
                        classes = {FileConfig.class, MqProcessor.class})})
@Log4j2
public class TigerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(TigerApplication.class, args);
        } catch (Throwable e) {
            log.error("", e);
        }
    }
}
