package com.demo.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(
        name = "api-client",
        path = "/api",
        url = "${API_URL}",
        dismiss404 = true
)
public interface ApiClient {

    @GetMapping
    Collection<ApiDTO> getAll();
}
