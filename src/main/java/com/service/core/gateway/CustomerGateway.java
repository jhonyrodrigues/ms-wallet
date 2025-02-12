package com.service.core.gateway;

import com.service.core.domain.CustomerDomain;

public interface CustomerGateway {

    CustomerDomain create(CustomerDomain customerDomain);

    CustomerDomain findByCpf(String cpf);
}
