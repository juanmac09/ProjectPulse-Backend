package com.example.projectpulse.controllers.projects;

import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.auth.read.AuthenticatedUser;
import com.example.projectpulse.dtos.project.read.ProjectNameAndDescriptionDto;
import com.example.projectpulse.serviceInterfaces.project.IProjectReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectReadController {

    private final AuthenticatedUser authenticatedUser;
    private final IProjectReadService projectReadService;

    public ProjectReadController(AuthenticatedUser authenticatedUser, IProjectReadService projectReadService) {
        this.authenticatedUser = authenticatedUser;
        this.projectReadService = projectReadService;
    }


    /**
     * Handles HTTP GET requests to retrieve all projects with pagination.
     *
     * @param page The page number to retrieve.
     * @param size The number of projects per page.
     * @return A ResponseEntity containing an AnswerRequests object with the list of projects, success status, and a message.
     */
    @GetMapping("/all")
    public ResponseEntity<AnswerRequests<Page<ProjectNameAndDescriptionDto>>> getAllProjects(@RequestParam int page, @RequestParam int size) {
        AnswerRequests<Page<ProjectNameAndDescriptionDto>> answerRequests = new AnswerRequests<Page<ProjectNameAndDescriptionDto>>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("All projects");
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(this.projectReadService.getAllProjects(pageable,this.authenticatedUser.getUser().getCompanyId()));
        return new ResponseEntity<AnswerRequests<Page<ProjectNameAndDescriptionDto>>>(answerRequests, HttpStatus.OK);
    }


    /**
     * Handles HTTP GET requests to search for projects based on a keyword with pagination.
     *
     * @param page The page number to retrieve.
     * @param size The number of projects per page.
     * @param word The keyword to search for in project names and descriptions.
     * @return A ResponseEntity containing an AnswerRequests object with the search results, success status, and a message.
     */
    @GetMapping("/search")
    public ResponseEntity<AnswerRequests<Page<ProjectNameAndDescriptionDto>>> searchProjects(@RequestParam int page, @RequestParam int size, @RequestParam String word) {
        AnswerRequests<Page<ProjectNameAndDescriptionDto>> answerRequests = new AnswerRequests<Page<ProjectNameAndDescriptionDto>>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("Result projects");
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(this.projectReadService.SearchProject(
                pageable,
                word,
                this.authenticatedUser.getUser().getCompanyId()
        ));

        return new ResponseEntity<AnswerRequests<Page<ProjectNameAndDescriptionDto>>>(answerRequests, HttpStatus.OK);
    }


}
