package com.example.projectpulse.entities;

import jakarta.persistence.*;

@Table(name = "projects")
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;


    public Project() {}
    public Project( String name, String description, Company companyId) {
        this.setName(name);
        this.setDescription(description);
        this.setCompanyId(companyId);
    }


    // Setters and getters here...
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompanyId() {
        return this.companyId;
    }
    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }
}
