package com.service.entrypoint.api.dto;

import java.time.LocalDateTime;

public record CustomerResponseDTO(
        String fullName,
        String cpf,
        LocalDateTime createdAt
) {
}
