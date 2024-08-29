package com.example.projectpulse.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "companies")
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "nit",nullable = false,unique = true)
    private String nit;

    @Column(name = "phone",nullable = false)
    private String phone;

    @Column(name = "address",nullable = false)
    private String address;

    @Column(unique = true, length = 100, nullable = false, name = "email")
    private String email;

    @OneToMany(mappedBy = "companyId")
    private List<User> users;

    public Company() {}
    public Company(String name, String nit, String phone, String address, String email) {
        this.setName(name);
        this.setNit(nit);
        this.setPhone(phone);
        this.setAddress(address);
        this.setEmail(email);
    }


    //Setters and getters here...

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getNit() {
        return this.nit;
    }
    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getPhone() {
        return this.phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return this.address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }




}
