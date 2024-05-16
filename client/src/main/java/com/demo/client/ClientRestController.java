package com.demo.client;

import com.demo.client.api.ApiClient;
import com.demo.client.api.ApiDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping
public class ClientRestController {

    @Autowired
    private ApiClient apiClient;

    @GetMapping
    public Collection<ApiDTO> getAllApi() {
        return apiClient.getAll();
    }
}
