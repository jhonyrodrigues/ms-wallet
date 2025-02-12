package com.service.entrypoint.api.controller;

import com.service.entrypoint.api.dto.CustomerRequestDTO;
import com.service.entrypoint.api.dto.CustomerResponseDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CustomerApi {

    @PostMapping("/v1/customer/create")
    ResponseEntity<CustomerResponseDTO> create(@RequestBody @Valid CustomerRequestDTO data);

}
