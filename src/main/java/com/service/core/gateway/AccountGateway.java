package com.service.core.gateway;

import com.service.core.domain.AccountDomain;

public interface AccountGateway {

    AccountDomain create(String customerId);

}
