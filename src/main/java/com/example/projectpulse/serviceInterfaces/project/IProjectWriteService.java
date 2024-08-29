package com.example.projectpulse.serviceInterfaces.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.dtos.project.write.ProjectCreateDto;
import com.example.projectpulse.dtos.project.write.ProjectUpdateDto;

public interface IProjectWriteService {

    ProjectGeneralDto createProject(ProjectCreateDto projectCreateDto);
    ProjectGeneralDto updateProject(Long id,ProjectUpdateDto projectUpdateDto);
}
