package com.example.projectpulse.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "companies")
@Entity
public class Company {

    // Primary key for the entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    // Field for the company's name, cannot be null.
    @Column(name = "name", nullable = false)
    private String name;

    // Field for the company's NIT (Tax Identification Number), must be unique and cannot be null.
    @Column(name = "nit", nullable = false, unique = true)
    private String nit;

    // Field for the company's phone number, cannot be null.
    @Column(name = "phone", nullable = false)
    private String phone;

    // Field for the company's address, cannot be null.
    @Column(name = "address", nullable = false)
    private String address;

    // Field for the company's email, must be unique and cannot be null.
    @Column(unique = true, length = 100, nullable = false, name = "email")
    private String email;

    // One-to-many relationship with the User entity. The 'company_id' field in User will map this relationship.
    @OneToMany(mappedBy = "companyId")
    private List<User> users;

    // One-to-many relationship with the Project entity. The 'company_id' field in Project will map this relationship.
    @OneToMany(mappedBy = "companyId")
    private List<Project> projects;

    // Default constructor.
    public Company() {}

    // Constructor with parameters to initialize the company with name, NIT, phone, address, and email.
    public Company(String name, String nit, String phone, String address, String email) {
        this.setName(name);
        this.setNit(nit);
        this.setPhone(phone);
        this.setAddress(address);
        this.setEmail(email);
    }

    // Getter for the company's ID.
    public Long getId() {
        return this.id;
    }

    // Getter for the company's name.
    public String getName() {
        return this.name;
    }

    // Setter for the company's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the company's NIT.
    public String getNit() {
        return this.nit;
    }

    // Setter for the company's NIT.
    public void setNit(String nit) {
        this.nit = nit;
    }

    // Getter for the company's phone number.
    public String getPhone() {
        return this.phone;
    }

    // Setter for the company's phone number.
    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter for the company's address.
    public String getAddress() {
        return this.address;
    }

    // Setter for the company's address.
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for the company's email.
    public String getEmail() {
        return this.email;
    }

    // Setter for the company's email.
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for the list of users associated with the company.
    public List<User> getUsers() {
        return this.users;
    }

    // Setter for the list of users associated with the company.
    public void setUsers(List<User> users) {
        this.users = users;
    }

    // Getter for the list of projects associated with the company.
    public List<Project> getProjects() {
        return this.projects;
    }

    // Setter for the list of projects associated with the company.
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
