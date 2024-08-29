package com.example.projectpulse.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "user_stories")
@Entity
public class UserStory {

    // Primary key for the entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Field for the user story's title, cannot be null.
    @Column(name = "title", nullable = false)
    private String title;

    // Field for the user story's description, cannot be null.
    @Column(name = "description", nullable = false)
    private String description;

    // Many-to-one relationship with the Project entity.
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    // One-to-many relationship with the Ticket entity. The 'user_story_id' field in Ticket will map this relationship.
    @OneToMany(mappedBy = "userStoryId")
    private List<Ticket> tickets;

    // Default constructor.
    public UserStory() {}

    // Getter for the user story's ID.
    public Long getId() {
        return this.id;
    }

    // Getter for the user story's title.
    public String getTitle() {
        return this.title;
    }

    // Setter for the user story's title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the user story's description.
    public String getDescription() {
        return this.description;
    }

    // Setter for the user story's description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the associated project.
    public Project getProject() {
        return this.project;
    }

    // Setter for the associated project.
    public void setProject(Project project) {
        this.project = project;
    }

    // Getter for the list of tickets associated with the user story.
    public List<Ticket> getTickets() {
        return this.tickets;
    }

    // Setter for the list of tickets associated with the user story.
    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
