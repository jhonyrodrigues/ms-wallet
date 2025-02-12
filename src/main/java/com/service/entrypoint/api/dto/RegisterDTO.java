package com.service.entrypoint.api.dto;

import com.service.core.domain.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record RegisterDTO(
        @NotBlank(message = "E-mail is required")
        @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "The email with invalid format")
        String email,
        @NotBlank(message = "Password is required")
        String password,
        UserRole role
) {
}
