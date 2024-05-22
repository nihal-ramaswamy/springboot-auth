package com.training.training.dto;

import java.util.List;

public record UserDto(String username, String email, List<String> roles) {
}
