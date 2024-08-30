package com.example.projectpulse.mapping.project;

import com.example.projectpulse.dtos.project.read.ProjectNameAndDescriptionDto;
import com.example.projectpulse.entities.Project;
import com.example.projectpulse.mapping.Mapper;
import org.springframework.stereotype.Component;

@Component
public class NameAndDescriptionProjectMapper implements Mapper<ProjectNameAndDescriptionDto,Project> {

    /**
     * Converts a Project entity into a ProjectNameAndDescriptionDto.
     *
     * @param project The Project entity to convert.
     * @return A ProjectNameAndDescriptionDto with the project details, or null if the input project is null.
     */
    @Override
    public ProjectNameAndDescriptionDto map(Project project) {
        if (project == null) return null;

        ProjectNameAndDescriptionDto projectNameAndDescriptionDto = new ProjectNameAndDescriptionDto();
        projectNameAndDescriptionDto.setId(project.getId());
        projectNameAndDescriptionDto.setName(project.getName());
        projectNameAndDescriptionDto.setDescription(project.getDescription());

        return projectNameAndDescriptionDto;
    }


}
