package com.example.projectpulse.services.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.entities.Project;
import com.example.projectpulse.mapping.project.GeneralProjectMapper;
import com.example.projectpulse.repositories.project.ProjectRepository;
import com.example.projectpulse.serviceInterfaces.project.IProjectReadService;
import org.springframework.stereotype.Service;

@Service
public class ProjectReadService implements IProjectReadService {

    private final ProjectRepository projectRepository;
    private final GeneralProjectMapper generalProjectMapper;

    public ProjectReadService(ProjectRepository projectRepository, GeneralProjectMapper generalProjectMapper) {
        this.projectRepository = projectRepository;
        this.generalProjectMapper = generalProjectMapper;
    }

    /**
     * Retrieves a project by its ID.
     *
     * @param id The ID of the project to retrieve.
     * @param companyId The ID of the company.
     * @return A ProjectGeneralDto object containing the project data, or null if the project is not found.
     */
    @Override
    public ProjectGeneralDto getProject(long id, Company companyId) {
        Project project = this.projectRepository.findByIdAndCompanyId(id,companyId);
        if (project == null) {
            return null;
        }
        return this.generalProjectMapper.map(project);
    }
}
