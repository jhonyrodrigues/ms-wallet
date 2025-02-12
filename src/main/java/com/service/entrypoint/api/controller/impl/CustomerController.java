package com.service.entrypoint.api.controller.impl;

import com.service.core.usecase.CustomerUseCase;
import com.service.entrypoint.api.controller.CustomerApi;
import com.service.entrypoint.api.dto.CustomerRequestDTO;
import com.service.entrypoint.api.dto.CustomerResponseDTO;
import com.service.entrypoint.api.exception.CustomerAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

    private final CustomerUseCase customerUseCase;

    public CustomerController(final CustomerUseCase customerUseCase) {
        this.customerUseCase = customerUseCase;
    }

    @Override
    public ResponseEntity<CustomerResponseDTO> create(final CustomerRequestDTO data) {
        if (customerUseCase.findByCpf(data.cpf()) != null)
            throw new CustomerAlreadyExistsException("Customer already registered");
        return ResponseEntity.ok(customerUseCase.create(data));
    }
}
