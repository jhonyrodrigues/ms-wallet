package com.service.core.usecase.impl;

import com.service.core.auth.security.TokenService;
import com.service.core.usecase.AuthenticationUseCase;
import com.service.dataprovider.database.entity.UserEntity;
import com.service.entrypoint.api.dto.AuthenticationDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationUseCaseImpl implements AuthenticationUseCase {

    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public AuthenticationUseCaseImpl(final AuthenticationManager authenticationManager, final TokenService tokenService) {
        this.authenticationManager = authenticationManager;
        this.tokenService = tokenService;
    }

    @Override
    public String authenticate(final AuthenticationDTO authenticationDTO) {
        var userAuthentication = new UsernamePasswordAuthenticationToken(authenticationDTO.login(), authenticationDTO.password());
        var authentication = authenticationManager.authenticate(userAuthentication);
        return tokenService.generateToken((UserEntity) authentication.getPrincipal());
    }

}
