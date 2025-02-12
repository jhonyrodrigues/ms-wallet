package com.service.core.domain;

import java.time.LocalDateTime;

public class CustomerDomain {
    String firstName;
    String lastName;
    String cpf;
    String phoneNumber;
    LocalDateTime createdAt;

    public CustomerDomain(String firstName, String lastName, String cpf, String phoneNumber, LocalDateTime createdAt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
