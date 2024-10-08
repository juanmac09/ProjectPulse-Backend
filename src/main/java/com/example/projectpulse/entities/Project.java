package com.example.projectpulse.entities;

import jakarta.persistence.*;
import java.util.List;

@Table(name = "projects")
@Entity
public class Project {

    // Primary key for the entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // Field for the project's name, cannot be null.
    @Column(name = "name", nullable = false)
    private String name;

    // Field for the project's description, cannot be null.
    @Column(name = "description", nullable = false)
    private String description;

    // Many-to-one relationship with the Company entity.
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company companyId;

    // One-to-many relationship with the UserStory entity.
    @OneToMany(mappedBy = "project")
    private List<UserStory> userStories;

    // Default constructor.
    public Project() {}

    // Constructor with parameters to initialize the project with name, description, and company.
    public Project(String name, String description, Company companyId) {
        this.setName(name);
        this.setDescription(description);
        this.setCompanyId(companyId);
    }

    // Getter for the project's ID.
    public Long getId() {
        return this.id;
    }

    // Getter for the project's name.
    public String getName() {
        return this.name;
    }

    // Setter for the project's name.
    public void setName(String name) {
        this.name = name;
    }

    // Getter for the project's description.
    public String getDescription() {
        return this.description;
    }

    // Setter for the project's description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the associated company.
    public Company getCompanyId() {
        return this.companyId;
    }

    // Setter for the associated company.
    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }

    // Getter for the list of user stories associated with the project.
    public List<UserStory> getUserStories() {
        return this.userStories;
    }

    // Setter for the list of user stories associated with the project.
    public void setUserStories(List<UserStory> userStories) {
        this.userStories = userStories;
    }
}
