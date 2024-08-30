package com.example.projectpulse.dtos.project.read;

public class ProjectNameAndDescriptionDto {
    private Long id;
    private String name;
    private String description;

    //Setters and Getters here...

    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
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
}
