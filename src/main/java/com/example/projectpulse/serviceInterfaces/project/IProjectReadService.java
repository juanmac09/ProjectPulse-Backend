package com.example.projectpulse.serviceInterfaces.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.entities.Company;

public interface IProjectReadService {

    ProjectGeneralDto getProject(long id, Company companyId);
}
