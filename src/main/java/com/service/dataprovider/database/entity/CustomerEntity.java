package com.service.dataprovider.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;

@Entity
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @OneToOne
    UserEntity user;
    @Column(unique = true)
    String firstName;
    String lastName;
    @Column(unique = true)
    String cpf;
    @Column(unique = true)
    String phoneNumber;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public CustomerEntity() {
    }

    public CustomerEntity(UserEntity user, String firstName, String lastName, String cpf, String phoneNumber, LocalDateTime createdAt) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.phoneNumber = phoneNumber;
        this.createdAt = createdAt;
    }

    public UserEntity getUser() {
        return user;
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
