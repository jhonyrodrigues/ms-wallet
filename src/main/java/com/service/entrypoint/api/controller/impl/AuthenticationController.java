package com.service.entrypoint.api.controller.impl;

import com.service.core.usecase.AuthenticationUseCase;
import com.service.core.usecase.UserUseCase;
import com.service.entrypoint.api.controller.AuthenticationApi;
import com.service.entrypoint.api.dto.AuthenticationDTO;
import com.service.entrypoint.api.dto.LoginResponseDTO;
import com.service.entrypoint.api.dto.RegisterDTO;
import com.service.entrypoint.api.dto.UserDTO;
import com.service.entrypoint.api.exception.UserAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController implements AuthenticationApi {

    private final AuthenticationUseCase authenticationUseCase;
    private final UserUseCase userUseCase;

    public AuthenticationController(final AuthenticationUseCase authenticationUseCase, final UserUseCase userUseCase) {
        this.authenticationUseCase = authenticationUseCase;
        this.userUseCase = userUseCase;
    }

    @Override
    public ResponseEntity<LoginResponseDTO> login(final AuthenticationDTO data) {
        return ResponseEntity.ok(new LoginResponseDTO(authenticationUseCase.authenticate(data)));
    }

    @Override
    public ResponseEntity<UserDTO> register(final RegisterDTO data) {
        if (userUseCase.findByEmail(data.email()) != null)
            throw new UserAlreadyExistsException("Login already registered");
        return ResponseEntity.ok(userUseCase.register(data));
    }
}
