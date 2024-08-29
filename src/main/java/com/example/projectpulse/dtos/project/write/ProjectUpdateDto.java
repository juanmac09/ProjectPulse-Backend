package com.example.projectpulse.dtos.project.write;


import jakarta.validation.constraints.Size;

public class ProjectUpdateDto {

    @Size(min = 3, message = "The name field does not meet the character length")
    private String name;

    @Size(min = 10, message = "The description field does not meet the character length")
    private String description;

    // Setters and getters here...
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

}
