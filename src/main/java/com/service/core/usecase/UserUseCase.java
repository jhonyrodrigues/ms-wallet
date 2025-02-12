package com.service.core.usecase;

import com.service.entrypoint.api.dto.RegisterDTO;
import com.service.entrypoint.api.dto.UserDTO;

public interface UserUseCase {

    UserDTO register(RegisterDTO registerDTO);

    UserDTO findByEmail(String login);

}
