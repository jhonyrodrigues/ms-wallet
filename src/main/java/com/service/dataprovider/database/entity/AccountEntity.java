package com.service.dataprovider.database.entity;

import com.service.core.domain.StatusAccount;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;
    @OneToOne
    CustomerEntity customer;
    BigDecimal balance;
    @Enumerated(EnumType.STRING)
    StatusAccount statusAccount;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public AccountEntity(final CustomerEntity customer) {
        this.customer = customer;
        this.balance = BigDecimal.ZERO;
        this.statusAccount = StatusAccount.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public StatusAccount getStatus() {
        return statusAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
