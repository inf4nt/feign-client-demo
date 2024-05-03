package com.demo.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class ApplicationEventListener {

    @Autowired
    private ApiClient apiClient;

    @EventListener
    public void listener(ApplicationReadyEvent event) {
        log.info("Event {}", event);

        Collection<ApiDTO> all = apiClient.getAll();

        log.info("Api answer : {}", all);
    }
}
