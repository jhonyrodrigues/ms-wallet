package com.service.entrypoint.api.dto;

public record AuthenticationDTO(
        String login,
        String password
) {
}
