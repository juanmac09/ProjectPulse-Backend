package com.example.projectpulse.dtos.userstory.write;

import com.example.projectpulse.entities.Project;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserStoryCreateDto {

    @NotNull(message = "The title column is mandatory")
    @Size(min = 3, message = "Error in required character length")
    private String title;
    @NotNull(message = "The description column is mandatory")
    @Size(min = 10, message = "Error in required character length")
    private String description;
    @NotNull(message = "The project id column is mandatory")
    private Project projectId;

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

    public Project getProjectId() {
        return this.projectId;
    }
    public void setProjectId(Project projectId) {
        this.projectId = projectId;
    }


}
