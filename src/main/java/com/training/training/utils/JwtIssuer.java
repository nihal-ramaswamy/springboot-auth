package com.training.training.utils;

import com.auth0.jwt.JWT;
import com.training.training.constants.Constants;
import com.training.training.dto.UserDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@Service
public class JwtIssuer {
    @Value("${jwt.token.secret}")
    private String secret;

    public String generateToken(@NotNull UserDto userDto) {
        return JWT
                .create()
                .withSubject(userDto.username())
                .withExpiresAt(Instant.now().plus(1, ChronoUnit.DAYS))
                .withClaim(Constants.EMAIL, userDto.email())
                .withClaim(Constants.AUTHORITIES, userDto.roles())
                .sign(Constants.ALGORITHM.algorithm(secret));
    }
}
