package com.Group2.feedback_analytics_consumer.conrollers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/")
public class HealthController {

    @GetMapping("/health")
    public ResponseEntity<Map> health() {
        return  ResponseEntity.ok().body(Map.of("status", "OK"));
    }
}
