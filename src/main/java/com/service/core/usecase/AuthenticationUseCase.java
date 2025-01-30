package com.service.core.usecase;

import com.service.entrypoint.api.dto.AuthenticationDTO;

public interface AuthenticationUseCase {

    String authenticate(AuthenticationDTO authenticationDTO);

}
