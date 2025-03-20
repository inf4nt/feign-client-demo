package com.demo.client.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Slf4j
@Component
@ConditionalOnProperty(name = "api.spam.enabled", havingValue = "true")
public class ApiSpamComponent {

    @Autowired
    private ApiClient apiClient;

    @Scheduled(fixedRate = 5000)
    public void listener() {
        log.info("Calling api server");
        Collection<ApiDTO> all = apiClient.getAll();
        log.info("Api response {}", all);
    }
}
