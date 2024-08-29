package com.example.projectpulse.services.project;

import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.dtos.project.write.ProjectCreateDto;
import com.example.projectpulse.dtos.project.write.ProjectUpdateDto;
import com.example.projectpulse.entities.Project;
import com.example.projectpulse.exception.project.ProjectNotFoundException;
import com.example.projectpulse.mapping.project.GeneralProjectMapper;
import com.example.projectpulse.repositories.project.ProjectRepository;
import com.example.projectpulse.serviceInterfaces.project.IProjectWriteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class ProjectWriteService implements IProjectWriteService {

    private final ProjectRepository projectRepository;
    private final GeneralProjectMapper generalProjectMapper;

    // Constructor for dependency injection.
    public ProjectWriteService(ProjectRepository projectRepository, GeneralProjectMapper generalProjectMapper) {
        this.projectRepository = projectRepository;
        this.generalProjectMapper = generalProjectMapper;
    }


    /**
     * Creates a new project from the given ProjectCreateDto.
     *
     * @param projectCreateDto The DTO containing project details to create.
     * @return A ProjectGeneralDto containing the details of the created project.
     */
    @Transactional
    @Override
    public ProjectGeneralDto createProject(ProjectCreateDto projectCreateDto) {
        Project project = new Project(projectCreateDto.getName(), projectCreateDto.getDescription(), projectCreateDto.getCompanyId());
        return this.generalProjectMapper.map(this.projectRepository.save(project));
    }

    /**
     * Updates an existing project with the provided data and returns the updated project details.
     *
     * @param id The ID of the project to be updated.
     * @param projectUpdateDto The data for updating the project.
     * @return The updated project data as a ProjectGeneralDto.
     * @throws ProjectNotFoundException If the project with the given ID is not found.
     */
    @Transactional
    @Override
    public ProjectGeneralDto updateProject(Long id, ProjectUpdateDto projectUpdateDto) throws ProjectNotFoundException {
        Project project = this.projectRepository.findById(id).orElse(null);
        if (project == null) {
            throw new ProjectNotFoundException("The project with " + id + " is not registered");
        }

        if (projectUpdateDto.getName() != null) project.setName(projectUpdateDto.getName());
        if (projectUpdateDto.getDescription() != null) project.setDescription(projectUpdateDto.getDescription());

        this.projectRepository.save(project);

        return this.generalProjectMapper.map(this.projectRepository.save(project));
    }

}
