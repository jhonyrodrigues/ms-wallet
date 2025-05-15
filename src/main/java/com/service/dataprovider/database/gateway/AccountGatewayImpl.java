package com.service.dataprovider.database.gateway;

import com.service.core.domain.AccountDomain;
import com.service.core.gateway.AccountGateway;
import com.service.dataprovider.database.entity.AccountEntity;
import com.service.dataprovider.database.repository.AccountRepository;
import com.service.dataprovider.database.repository.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class AccountGatewayImpl implements AccountGateway {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    public AccountGatewayImpl(final AccountRepository accountRepository, final CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    public AccountDomain create(final String customerId) {
        var customer = customerRepository.findById(customerId).orElseThrow();
        var account = accountRepository.save(new AccountEntity(customer));
        return new AccountDomain(account.getId(), customerId, account.getBalance(), account.getStatus(), account.getCreatedAt());
    }
}
