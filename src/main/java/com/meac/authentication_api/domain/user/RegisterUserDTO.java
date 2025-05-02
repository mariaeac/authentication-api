package com.meac.authentication_api.domain.user;

public record RegisterUserDTO(String username, String password, UserRole role) {
}
