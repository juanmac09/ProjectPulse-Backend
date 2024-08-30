package com.example.projectpulse.dtos.userstory.write;


import com.example.projectpulse.entities.Project;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserStoryUpdatedDto {

    @Size(min = 3, message = "Error in required character length")
    private String title;

    @Size(min = 10, message = "Error in required character length")
    private String description;

    //Setters and getters here...
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
}
