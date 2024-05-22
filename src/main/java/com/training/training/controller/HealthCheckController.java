package com.training.training.controller;

import com.training.training.dto.HealthCheckDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/healthcheck")
public class HealthCheckController {
    @GetMapping("")
    public ResponseEntity<HealthCheckDto> healthCheck() {
        return new ResponseEntity<>(new HealthCheckDto("Hello World"), HttpStatus.OK);
    }
}
