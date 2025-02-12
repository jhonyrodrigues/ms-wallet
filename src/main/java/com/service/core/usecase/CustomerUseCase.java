package com.service.core.usecase;

import com.service.entrypoint.api.dto.CustomerRequestDTO;
import com.service.entrypoint.api.dto.CustomerResponseDTO;

public interface CustomerUseCase {

    CustomerResponseDTO create(CustomerRequestDTO customerRequestDTO);

    CustomerResponseDTO findByCpf(String cpf);

}
