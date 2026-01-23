package com.example.dreamservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "dreamer-service")
public interface DreamerClient {

    @GetMapping("/dreamers/{id}")
    void checkDreamerExists(@PathVariable Long id);
}
