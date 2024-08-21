package com.demo.client;

import com.demo.client.api.ApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.LinkedHashMap;

@RestController
@RequestMapping
public class ClientRestController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping
    public Object getAllApi() {
        var apiResponse = apiClient.getAll();
        var response = new LinkedHashMap<>();
        response.put("client_request_timestamp", Instant.now().toEpochMilli());
        response.put("api_resources", apiResponse);
        return response;
    }
}
