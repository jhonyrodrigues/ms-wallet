package com.service.entrypoint.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CustomerRequestDTO(
        @NotBlank(message = "First Name is required")
        String firstName,
        @NotBlank(message = "Last Name is required")
        String lastName,
        @NotBlank(message = "CPF is required")
        @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 dígitos numéricos")
        String cpf,
        @NotBlank(message = "Phone number is required")
        @Pattern(regexp = "^\\+?\\d{1,3}\\s?\\(?\\d{2,3}\\)?\\s?\\d{4,5}-?\\d{4}$", message = "The phone number must have 10 or 11 digits")
        String phoneNumber
) {
}
