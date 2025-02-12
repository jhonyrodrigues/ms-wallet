package com.service.core.usecase.impl;

import com.service.core.domain.UserDomain;
import com.service.core.gateway.UserGateway;
import com.service.core.usecase.UserUseCase;
import com.service.entrypoint.api.dto.RegisterDTO;
import com.service.entrypoint.api.dto.UserDTO;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserUserCaseImpl implements UserUseCase {

    private final UserGateway userGateway;

    public UserUserCaseImpl(final UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    @Override
    public UserDTO register(final RegisterDTO registerDTO) {
        String encryptedPassword = new BCryptPasswordEncoder().encode(registerDTO.password());
        var userDomain = new UserDomain(registerDTO.email(), encryptedPassword, registerDTO.role());
        var user = userGateway.register(userDomain);
        return new UserDTO(user.getLogin());
    }

    @Override
    public UserDTO findByEmail(final String email) {
        var userDomain = userGateway.findByLogin(email);
        return userDomain != null ? new UserDTO(userDomain.getLogin()) : null;
    }
}
