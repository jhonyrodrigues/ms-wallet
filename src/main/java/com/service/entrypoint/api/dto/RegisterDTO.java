package com.service.entrypoint.api.dto;

import com.service.core.domain.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
