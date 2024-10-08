package com.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping
public class ApiRestController {

    @GetMapping
    public String index() {
        return ApiApplication.class.getSimpleName();
    }

    @GetMapping("/api")
    public Collection<ApiDTO> getAll() {
        return List.of(
                new ApiDTO(ApiApplication.class.getSimpleName(), UUID.randomUUID().toString(), ApiStatus.RUNNING),
                new ApiDTO(ApiApplication.class.getSimpleName(), UUID.randomUUID().toString(), ApiStatus.CLOSED)
        );
    }
}
