package com.service.core.mapper;

import com.service.core.domain.CustomerDomain;
import com.service.dataprovider.database.entity.CustomerEntity;
import com.service.dataprovider.database.entity.UserEntity;
import com.service.entrypoint.api.dto.CustomerRequestDTO;
import com.service.entrypoint.api.dto.CustomerResponseDTO;

import java.time.LocalDateTime;

public final class CustomerMapper {

    public static CustomerDomain toCustomerDomain(CustomerRequestDTO customerRequestDTO) {
        return new CustomerDomain(
                customerRequestDTO.firstName(),
                customerRequestDTO.lastName(),
                customerRequestDTO.cpf(),
                customerRequestDTO.phoneNumber(),
                LocalDateTime.now());
    }

    public static CustomerDomain toCustomerDomain(CustomerEntity customerEntity) {
        return new CustomerDomain(
                customerEntity.getFirstName(),
                customerEntity.getLastName(),
                customerEntity.getCpf(),
                customerEntity.getPhoneNumber(),
                customerEntity.getCreatedAt()
        );
    }

    public static CustomerResponseDTO toCustomerResponseDTO(CustomerDomain customerDomain) {
        return new CustomerResponseDTO(
                customerDomain.getFirstName() + " " + customerDomain.getLastName(),
                customerDomain.getCpf(),
                customerDomain.getCreatedAt());
    }

    public static CustomerEntity toCustomerEntity(CustomerDomain customerDomain, UserEntity userEntity) {
        return new CustomerEntity(
                userEntity,
                customerDomain.getFirstName(),
                customerDomain.getLastName(),
                customerDomain.getCpf(),
                customerDomain.getPhoneNumber(),
                LocalDateTime.now());
    }
}
