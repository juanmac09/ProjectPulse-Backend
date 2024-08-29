package com.example.projectpulse.entities;

import jakarta.persistence.*;

@Table(name = "user_stories")
@Entity
public class UserStory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false)
    private Long id;


    @Column(name = "title",nullable = false)
    private String title;

    @Column(name = "description",nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public UserStory() {}

    // Setters and getters here...

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Project getProject() {
        return this.project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
}
