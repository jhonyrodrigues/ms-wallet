package com.service.core.usecase.impl;

import com.service.core.gateway.AccountGateway;
import com.service.core.usecase.AccountUseCase;
import com.service.entrypoint.api.dto.AccountCreateResponseDTO;
import org.springframework.stereotype.Component;

@Component
public class AccountUseCaseImpl implements AccountUseCase {

    private final AccountGateway accountGateway;

    public AccountUseCaseImpl(final AccountGateway accountGateway) {
        this.accountGateway = accountGateway;
    }

    @Override
    public AccountCreateResponseDTO create(final String customerId) {
        var account = accountGateway.create(customerId);
        return new AccountCreateResponseDTO(account.getId());
    }
}
