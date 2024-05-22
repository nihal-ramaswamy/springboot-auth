package com.training.training.controller;

import com.training.training.dto.LoginRequestDto;
import com.training.training.dto.LoginResponseDto;
import com.training.training.dto.UserDto;
import com.training.training.utils.JwtIssuer;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtIssuer jwtIssuer;

    @Autowired
    public AuthController(JwtIssuer jwtIssuer) {
        this.jwtIssuer = jwtIssuer;
    }

    @GetMapping("/healthcheck")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<String> testAuth() {
        return new ResponseEntity<>("Authenticated", HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody @Validated LoginRequestDto loginRequestDto) {
        var token = this.jwtIssuer.generateToken(new UserDto(loginRequestDto.email(), loginRequestDto.email(), new ArrayList<>()));
        return new ResponseEntity<>(new LoginResponseDto(token), HttpStatus.ACCEPTED);
    }
}
