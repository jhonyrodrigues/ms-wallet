package com.service.core.usecase;

import com.service.entrypoint.api.dto.AccountCreateResponseDTO;

public interface AccountUseCase {

    AccountCreateResponseDTO create(String customerId);

}
