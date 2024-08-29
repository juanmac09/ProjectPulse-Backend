package com.example.projectpulse.controllers.projects;

import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.auth.read.AuthenticatedUser;
import com.example.projectpulse.dtos.project.read.ProjectGeneralDto;
import com.example.projectpulse.dtos.project.write.ProjectCreateDto;
import com.example.projectpulse.dtos.project.write.ProjectUpdateDto;
import com.example.projectpulse.serviceInterfaces.project.IProjectReadService;
import com.example.projectpulse.serviceInterfaces.project.IProjectWriteService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project")
public class ProjectsController {

    private final IProjectWriteService projectWriteService;
    private final AuthenticatedUser authenticatedUser;
    private final IProjectReadService projectReadService;

    // Constructor for dependency injection.
    public ProjectsController(AuthenticatedUser authenticatedUser, IProjectWriteService projectWriteService, IProjectReadService projectReadService) {
        this.authenticatedUser = authenticatedUser;
        this.projectWriteService = projectWriteService;
        this.projectReadService = projectReadService;
    }

    /**
     * Creates a new project using the provided ProjectCreateDto.
     *
     * @param projectCreateDto The DTO containing project details to create.
     * @return A ResponseEntity containing AnswerRequests with ProjectGeneralDto.
     */
    @PostMapping("/created")
    public ResponseEntity<AnswerRequests<ProjectGeneralDto>> createProject(@Valid @RequestBody ProjectCreateDto projectCreateDto) {
        AnswerRequests<ProjectGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("User has been created");

        projectCreateDto.setCompanyId(this.authenticatedUser.getUser().getCompanyId());

        answerRequests.setData(this.projectWriteService.createProject(projectCreateDto));

        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Updates an existing project based on its ID and the information provided in the request body.
     *
     * @param id The ID of the project to be updated.
     * @param projectUpdateDto The updated project data.
     * @return A response with the status of the request and the updated project data.
     */
    @PutMapping("/update/{id}")
    public ResponseEntity<AnswerRequests<ProjectGeneralDto>> updateProject(
            @NotNull @PathVariable Long id,
            @Valid @RequestBody ProjectUpdateDto projectUpdateDto) {

        AnswerRequests<ProjectGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("User has been updated");

        answerRequests.setData(this.projectWriteService.updateProject(id, projectUpdateDto));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Retrieves a project by its ID.
     *
     * @param id The ID of the project to retrieve.
     * @return A ResponseEntity containing the AnswerRequests object with the project data and an HTTP status of OK.
     */
    @GetMapping("/{id}")
    public ResponseEntity<AnswerRequests<ProjectGeneralDto>> getProject(@PathVariable Long id) {
        AnswerRequests<ProjectGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setData(this.projectReadService.getProject(id,this.authenticatedUser.getUser().getCompanyId()));

        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }

}
