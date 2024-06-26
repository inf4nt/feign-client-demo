package com.demo.client;

import com.demo.client.api.ApiClient;
import com.demo.client.api.ApiDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
public class ApiServerTestCall {

    @Autowired
    private ApiClient apiClient;

    @EventListener(ApplicationReadyEvent.class)
    public void listener() {
        log.info("Calling api server");
        Collection<ApiDTO> all = apiClient.getAll();
        log.info("Api response {}", all);
    }
}
