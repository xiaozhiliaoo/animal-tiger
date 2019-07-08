package org.lili.forfun.tiger.service;

import lombok.extern.log4j.Log4j2;
import org.lili.forfun.infra.api.ServiceRegisterApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class TigerLifeCycle implements ApplicationListener<ApplicationReadyEvent> {
    private static final String SERVICE_KEY = "tiger";

    @Autowired
    private ServiceRegisterApi serviceRegisterApi;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        //registerService();
        log.info("Tiger Started!");
    }

    private void registerService() {
        this.serviceRegisterApi.registerServer(SERVICE_KEY, null);
    }
}
