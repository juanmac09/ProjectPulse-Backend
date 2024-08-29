package com.example.projectpulse.dtos.company.read;

public class GeneralCompanyDto {

    private Long id;
    private String name;

    /**
     * Gets the ID of the company.
     *
     * @return The ID of the company.
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the ID of the company.
     *
     * @param id The ID to set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the name of the company.
     *
     * @return The name of the company.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of the company.
     *
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
