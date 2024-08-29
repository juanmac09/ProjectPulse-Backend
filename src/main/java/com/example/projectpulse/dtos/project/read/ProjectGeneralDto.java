package com.example.projectpulse.dtos.project.read;

import com.example.projectpulse.dtos.company.read.GeneralCompanyDto;

public class ProjectGeneralDto {

    private Long id;
    private String name;
    private String description;
    private GeneralCompanyDto generalCompany;

    // Setters and getters here...

    /**
     * Returns the ID of the project.
     *
     * @return The ID of the project.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the ID of the project.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Returns the name of the project.
     *
     * @return The name of the project.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the project.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the project.
     *
     * @return The description of the project.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Sets the description of the project.
     *
     * @param description The description to set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns the company associated with the project.
     *
     * @return The GeneralCompanyDto associated with the project.
     */
    public GeneralCompanyDto getGeneralCompany() {
        return this.generalCompany;
    }

    /**
     * Sets the company associated with the project.
     *
     * @param generalCompany The GeneralCompanyDto to set.
     */
    public void setGeneralCompany(GeneralCompanyDto generalCompany) {
        this.generalCompany = generalCompany;
    }
}
