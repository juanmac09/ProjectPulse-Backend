package com.example.projectpulse.serviceInterfaces.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.dtos.project.read.ProjectNameAndDescriptionDto;
import com.example.projectpulse.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProjectReadService {

    ProjectGeneralDto getProject(long id, Company companyId);
    Page<ProjectNameAndDescriptionDto> getAllProjects(Pageable pageable,Company companyId);
    Page<ProjectNameAndDescriptionDto> SearchProject(Pageable pageable,String searchTerm,Company companyId);
}
