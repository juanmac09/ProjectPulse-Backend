package com.example.projectpulse.dtos.userstory.read;

import com.example.projectpulse.dtos.project.read.ProjectNameAndDescriptionDto;

public class UserStoryGeneralDto {
    private long id;
    private String title;
    private String description;
    private ProjectNameAndDescriptionDto projectNameAndDescription;

    //Setters and Getters here
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
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

    public ProjectNameAndDescriptionDto getProjectNameAndDescription() {
        return this.projectNameAndDescription;
    }
    public void setProjectNameAndDescription(ProjectNameAndDescriptionDto projectNameAndDescription) {
        this.projectNameAndDescription = projectNameAndDescription;
    }
}
