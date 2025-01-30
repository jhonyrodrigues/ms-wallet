package com.service.entrypoint.api.controller;

import com.service.entrypoint.api.dto.AuthenticationDTO;
import com.service.entrypoint.api.dto.LoginResponseDTO;
import com.service.entrypoint.api.dto.RegisterDTO;
import com.service.entrypoint.api.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface AuthenticationApi {

    @PostMapping("/v1/authorization")
    ResponseEntity<LoginResponseDTO> login(AuthenticationDTO data);

    @PostMapping("/v1/register")
    ResponseEntity<UserDTO> register(RegisterDTO data);

}
