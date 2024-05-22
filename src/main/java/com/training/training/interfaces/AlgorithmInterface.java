package com.training.training.interfaces;

import com.auth0.jwt.algorithms.Algorithm;

@FunctionalInterface
public interface AlgorithmInterface {
    Algorithm algorithm(String secret);
}
