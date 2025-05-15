package com.service.entrypoint.api.controller.impl;

import com.service.core.usecase.AccountUseCase;
import com.service.entrypoint.api.controller.AccountApi;
import com.service.entrypoint.api.dto.AccountCreateResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController implements AccountApi {

    private final AccountUseCase accountUseCase;

    public AccountController(final AccountUseCase accountUseCase) {
        this.accountUseCase = accountUseCase;
    }

    @Override
    public ResponseEntity<AccountCreateResponseDTO> create(final String customerId) {
        return ResponseEntity.ok(accountUseCase.create(customerId));
    }
}
