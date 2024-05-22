package com.training.training.constants;

import com.auth0.jwt.algorithms.Algorithm;
import com.training.training.interfaces.AlgorithmInterface;
import org.springframework.stereotype.Component;

@Component
public class Constants {
    public static final AlgorithmInterface ALGORITHM = Algorithm::HMAC256;
    public static final String EMAIL = "email";
    public static final String AUTHORITIES = "authorities";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
}
