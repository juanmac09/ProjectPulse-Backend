package com.example.projectpulse.serviceInterfaces.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;

public interface IProjectReadService {

    ProjectGeneralDto getProject(long id);
}
