package com.Oscar.loginSys.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class User {
    // annotation here to validate the input
    @Email
    private String email;
    @NotEmpty
    private String password;

    public String getEmail() {
        return email;
    }

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
