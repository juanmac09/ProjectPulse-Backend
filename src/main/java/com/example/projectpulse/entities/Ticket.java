package com.example.projectpulse.entities;

import com.example.projectpulse.enums.ticket.Status;
import jakarta.persistence.*;

@Table(name = "tickets")
@Entity
public class Ticket {

    // Primary key for the entity, automatically generated.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    // Field for the ticket's description, cannot be null.
    @Column(name = "title", nullable = false)
    private String title;

    // Field for the ticket's description, cannot be null.
    @Column(name = "description", nullable = false)
    private String description;

    // Field for the ticket's status, cannot be null. Uses an enumerated type.
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private Status status;

    // Field for additional comments on the ticket, cannot be null.
    @Column(name = "comments", nullable = false)
    private String comments;

    // Many-to-one relationship with the UserStory entity. The 'user_story_id' field will map this relationship.
    @ManyToOne
    @JoinColumn(name = "user_story_id")
    private UserStory userStoryId;

    // Default constructor.
    public Ticket() {}

    // Constructor with parameters to initialize the ticket with description, status, comments, and user story.
    public Ticket(String description, Status status, String comments, UserStory userStoryId) {
        this.setDescription(description);
        this.setStatus(status);
        this.setComments(comments);
        this.setUserStoryId(userStoryId);
    }

    // Getter for the ticket's ID.
    public Long getId() {
        return this.id;
    }

    // Getter for the ticket's title.
    public String getTitle() {
        return this.title;
    }
    // Setter for the ticket's title.
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for the ticket's description.
    public String getDescription() {
        return this.description;
    }

    // Setter for the ticket's description.
    public void setDescription(String description) {
        this.description = description;
    }

    // Getter for the ticket's status.
    public Status getStatus() {
        return this.status;
    }

    // Setter for the ticket's status.
    public void setStatus(Status status) {
        this.status = status;
    }

    // Getter for the ticket's comments.
    public String getComments() {
        return this.comments;
    }

    // Setter for the ticket's comments.
    public void setComments(String comments) {
        this.comments = comments;
    }

    // Getter for the associated user story.
    public UserStory getUserStoryId() {
        return this.userStoryId;
    }

    // Setter for the associated user story.
    public void setUserStoryId(UserStory userStoryId) {
        this.userStoryId = userStoryId;
    }
}
