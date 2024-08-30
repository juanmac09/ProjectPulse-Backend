package com.example.projectpulse.services.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.dtos.project.read.ProjectNameAndDescriptionDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.entities.Project;
import com.example.projectpulse.mapping.project.GeneralProjectMapper;
import com.example.projectpulse.mapping.project.NameAndDescriptionProjectMapper;
import com.example.projectpulse.repositories.project.ProjectRepository;
import com.example.projectpulse.serviceInterfaces.project.IProjectReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectReadService implements IProjectReadService {

    private final ProjectRepository projectRepository;
    private final GeneralProjectMapper generalProjectMapper;
    private final NameAndDescriptionProjectMapper nameAndDescriptionProjectMapper;

    public ProjectReadService(ProjectRepository projectRepository, GeneralProjectMapper generalProjectMapper, NameAndDescriptionProjectMapper nameAndDescriptionProjectMapper) {
        this.projectRepository = projectRepository;
        this.generalProjectMapper = generalProjectMapper;
        this.nameAndDescriptionProjectMapper = nameAndDescriptionProjectMapper;
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

    /**
     * Retrieves all projects for a specific company with pagination.
     *
     * @param pageable The pagination information (page number and size).
     * @param companyId The company for which to retrieve the projects.
     * @return A Page of ProjectNameAndDescriptionDto containing the project details.
     */
    @Override
    public Page<ProjectNameAndDescriptionDto> getAllProjects(Pageable pageable, Company companyId) {
        Page<Project> projects = this.projectRepository.findAllByCompanyId(companyId, pageable);
        return projects.map(this.nameAndDescriptionProjectMapper::map);
    }

    /**
     * Searches for projects based on a search term and retrieves them with pagination.
     *
     * @param pageable The pagination information (page number and size).
     * @param searchTerm The term to search for in project names and descriptions.
     * @param companyId The company for which to search for projects.
     * @return A Page of ProjectNameAndDescriptionDto containing the search results.
     */
    @Override
    public Page<ProjectNameAndDescriptionDto> SearchProject(Pageable pageable, String searchTerm, Company companyId) {
        Page<Project> projects = this.projectRepository.searchProjectsByCompany(companyId.getId(), searchTerm, pageable);
        return projects.map(this.nameAndDescriptionProjectMapper::map);
    }

}
