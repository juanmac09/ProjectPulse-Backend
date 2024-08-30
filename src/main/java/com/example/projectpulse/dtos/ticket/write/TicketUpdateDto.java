package com.example.projectpulse.dtos.ticket.write;

import com.example.projectpulse.entities.UserStory;
import com.example.projectpulse.enums.ticket.Status;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TicketUpdateDto {

    @Size(min = 3, message = "The name field does not meet the character length")
    private String title;
    @Size(min = 2, message = "The field description is not of adequate length")
    private String description;
    private Status status;
    @Size(min = 2, message = "The field comment is not of adequate length")
    private String comment;

    // Setters and getters here...
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

    public Status getStatus() {
        return this.status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }

    public String getComment() {
        return this.comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }

}
