package com.example.projectpulse.entities;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@Entity
public class User implements UserDetails {

    // Primary key for the entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, name = "id")
    private Long id;

    // Field for the user's name, cannot be null.
    @Column(nullable = false, name = "name")
    private String name;

    // Field for the user's email, must be unique and cannot be null.
    @Column(unique = true, length = 100, nullable = false, name = "email")
    private String email;

    // Field for the user's password, cannot be null.
    @Column(nullable = false, name = "password")
    private String password;

    // Many-to-one relationship with the Company entity. The 'company_id' field cannot be null.
    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company companyId;

    // Default constructor.
    public User() {}

    // Constructor with parameters to initialize the user with name, email, password, and company.
    public User(String name, String email, String password, Company companyId) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
        this.setCompanyId(companyId);
    }

    // Method to get the authorities granted to the user. In this case, it returns an empty list.
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // Method to get the username, which is the user's email.
    @Override
    public String getUsername() {
        return email;
    }

    // Indicates whether the user's account is not expired. Always returns true.
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // Indicates whether the user's account is not locked. Always returns true.
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // Indicates whether the user's credentials are not expired. Always returns true.
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // Indicates whether the user is enabled. Always returns true.
    @Override
    public boolean isEnabled() {
        return true;
    }

    // Getter for the user's ID.
    public Long getId() {
        return this.id;
    }

    // Getter for the user's name.
    public String getName() {
        return this.name;
    }

    // Setter for the user's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the user's email.
    public String getEmail() {
        return this.email;
    }

    // Setter for the user's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the user's password.
    public String getPassword() {
        return this.password;
    }

    // Setter for the user's password.
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for the associated company.
    public Company getCompanyId() {
        return this.companyId;
    }

    // Setter for the associated company.
    public void setCompanyId(Company company_id) {
        this.companyId = company_id;
    }

}
