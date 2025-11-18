package com.Group2.feedback_analytics_consumer.conrollers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Swagger-ui
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;

import java.util.Map;

@Tag(name = "Consumer Health", description = "Operations related to application health status")
@RestController("/")
public class HealthController {

    @Operation(
            summary = "Check service health",
            description = "Returns a simple status payload confirming the application is running.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Service is healthy",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = Map.class)
                            )
                    )
            }
    )
    @GetMapping("/health")
    public ResponseEntity<Map> health() {
        return ResponseEntity.ok().body(Map.of("status", "OK"));
    }
}
