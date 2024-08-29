package com.example.projectpulse.dtos.auth.write;

import com.example.projectpulse.entities.Company;

public class RegisterUserDto {

    private String email;

    private String password;

    private String name;

    private Company company;

    // getters and setters here...
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Company getCompany() {
        return this.company;
    }
    public void setCompany(Company company) {
        this.company = company;
    }
}
