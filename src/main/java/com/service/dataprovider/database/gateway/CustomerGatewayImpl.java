package com.service.dataprovider.database.gateway;

import com.service.core.domain.CustomerDomain;
import com.service.core.gateway.CustomerGateway;
import com.service.dataprovider.database.repository.CustomerRepository;
import com.service.dataprovider.database.repository.UserRepository;
import org.springframework.stereotype.Component;

import static com.service.core.mapper.CustomerMapper.toCustomerDomain;
import static com.service.core.mapper.CustomerMapper.toCustomerEntity;
import static com.service.core.security.utils.UserUtils.getLoggedUser;

@Component
public class CustomerGatewayImpl implements CustomerGateway {

    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;

    public CustomerGatewayImpl(final CustomerRepository customerRepository, UserRepository userRepository) {
        this.customerRepository = customerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CustomerDomain create(final CustomerDomain customerDomain) {
        final var loggerUser = getLoggedUser();
        final var userEntity = userRepository.findByEmail(loggerUser);
        final var customerEntity = toCustomerEntity(customerDomain, userEntity);
        return toCustomerDomain(customerRepository.save(customerEntity));
    }

    @Override
    public CustomerDomain findByCpf(final String cpf) {
        final var customerEntity = customerRepository.findByCpf(cpf);
        return customerEntity != null ? toCustomerDomain(customerEntity) : null;
    }
}
