package com.service.core.usecase.impl;

import com.service.core.gateway.CustomerGateway;
import com.service.core.usecase.CustomerUseCase;
import com.service.entrypoint.api.dto.CustomerRequestDTO;
import com.service.entrypoint.api.dto.CustomerResponseDTO;
import org.springframework.stereotype.Component;

import static com.service.core.mapper.CustomerMapper.toCustomerDomain;
import static com.service.core.mapper.CustomerMapper.toCustomerResponseDTO;

@Component
public class CustomerUseCaseImpl implements CustomerUseCase {

    private final CustomerGateway customerGateway;

    public CustomerUseCaseImpl(final CustomerGateway customerGateway) {
        this.customerGateway = customerGateway;
    }

    @Override
    public CustomerResponseDTO create(final CustomerRequestDTO customerRequestDTO) {
        final var customerDomain = customerGateway.create(toCustomerDomain(customerRequestDTO));
        return toCustomerResponseDTO(customerDomain);
    }

    @Override
    public CustomerResponseDTO findByCpf(final String cpf) {
        final var customerDomain = customerGateway.findByCpf(cpf);
        return customerDomain != null ? toCustomerResponseDTO(customerDomain) : null;
    }
}
