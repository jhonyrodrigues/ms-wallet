package com.service.core.domain;

public class UserDomain {
    String login;
    String password;
    UserRole role;

    public UserDomain(String login, String password, UserRole role) {
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public UserDomain(String login, UserRole role) {
        this.login = login;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public UserRole getRole() {
        return role;
    }
}