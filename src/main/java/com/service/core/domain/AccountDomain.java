package com.service.core.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountDomain {
    String id;
    String userId;
    BigDecimal balance;
    StatusAccount statusAccount;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public AccountDomain(String id, String userId, BigDecimal balance, StatusAccount statusAccount, LocalDateTime createdAt) {
        this.id = id;
        this.userId = userId;
        this.balance = balance;
        this.statusAccount = statusAccount;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }
}
