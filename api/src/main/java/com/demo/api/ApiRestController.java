package com.demo.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping
public class ApiRestController {

    @GetMapping
    public String index() {
        log.info("root endpoint has called");
        return ApiApplication.class.getSimpleName();
    }

    @GetMapping("/health-check")
    public ResponseEntity<?> healthcheck() {
        log.info("/health-check has called");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/api")
    public Collection<ApiDTO> getAll() {
        log.info("/api called");
        return List.of(
                new ApiDTO(ApiApplication.class.getSimpleName(), UUID.randomUUID().toString(), ApiStatus.RUNNING),
                new ApiDTO(ApiApplication.class.getSimpleName(), UUID.randomUUID().toString(), ApiStatus.CLOSED)
        );
    }
}
