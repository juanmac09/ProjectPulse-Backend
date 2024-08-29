package com.example.projectpulse.mapping.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.entities.Project;
import com.example.projectpulse.mapping.Mapper;
import com.example.projectpulse.mapping.company.GeneralCompanyMapper;
import org.springframework.stereotype.Component;

@Component
public class GeneralProjectMapper implements Mapper<ProjectGeneralDto, Project> {

    private final GeneralCompanyMapper generalCompanyMapper;

    // Constructor for dependency injection.
    public GeneralProjectMapper(GeneralCompanyMapper generalCompanyMapper) {
        this.generalCompanyMapper = generalCompanyMapper;
    }

    /**
     * Maps a Project entity to a ProjectGeneralDto.
     *
     * @param project The Project entity to map.
     * @return The mapped ProjectGeneralDto, or null if the input project is null.
     */
    @Override
    public ProjectGeneralDto map(Project project) {
        if (project == null) return null;

        ProjectGeneralDto dto = new ProjectGeneralDto();
        dto.setId(project.getId());
        dto.setName(project.getName());
        dto.setDescription(project.getDescription());
        dto.setGeneralCompany(this.generalCompanyMapper.map(project.getCompanyId()));
        return dto;
    }
}
