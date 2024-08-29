package com.example.projectpulse.dtos.project.write;

import com.example.projectpulse.entities.Company;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ProjectCreateDto {
    @NotNull(message = "the name field cannot be null")
    @Size(min = 3, message = "The name field does not meet the character length")
    private String name;

    @NotNull(message = "the description field cannot be null")
    @Size(min = 10, message = "The description field does not meet the character length")
    private String description;

    private Company companyId;

    // Setters and getters here...

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
     * Returns the associated company.
     *
     * @return The company associated with the project.
     */
    public Company getCompanyId() {
        return this.companyId;
    }

    /**
     * Sets the associated company.
     *
     * @param companyId The company to set.
     */
    public void setCompanyId(Company companyId) {
        this.companyId = companyId;
    }
}
