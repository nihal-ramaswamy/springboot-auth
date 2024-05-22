package com.training.training.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.training.training.constants.Constants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtDecoder {
    @Value("${jwt.token.secret}")
    private String secret;

    public DecodedJWT decode(String token) {
        return JWT.require(Constants.ALGORITHM.algorithm(secret))
                .build()
                .verify(token);
    }
}
