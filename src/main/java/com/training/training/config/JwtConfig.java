package com.training.training.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "jwt.token")
public class JwtConfig {
    /**
     * Secret key for issuing JWTs
     */
    String secret;
}
