package com.example.projectpulse.controllers.userstories;


import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.auth.read.AuthenticatedUser;
import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.serviceInterfaces.userstory.IUserStoryReadService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-story")
public class UserStoryReadController {
    private final AuthenticatedUser authenticatedUser;
    private final IUserStoryReadService userStoryReadService;


    public UserStoryReadController(IUserStoryReadService userStoryReadService, AuthenticatedUser authenticatedUser) {
        this.userStoryReadService = userStoryReadService;
        this.authenticatedUser = authenticatedUser;


    }

    /**
     * Handles HTTP GET requests to retrieve a specific UserStory by its ID.
     *
     * @param id The ID of the UserStory to retrieve.
     * @return A ResponseEntity containing an AnswerRequests object with the UserStory details, success status, and a message.
     */
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<AnswerRequests<UserStoryGeneralDto>> getUserStory(@PathVariable Long id) {
        AnswerRequests<UserStoryGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("User Story");

        answerRequests.setData(this.userStoryReadService.getUserStory(
                id,
                this.authenticatedUser.getUser().getCompanyId()
        ));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }

    /**
     * Handles HTTP GET requests to retrieve all User Stories for the authenticated user's company with pagination.
     *
     * @param page The page number to retrieve.
     * @param size The number of User Stories per page.
     * @return A ResponseEntity containing an AnswerRequests object with a paginated list of User Stories, success status, and a message.
     */
    @GetMapping("/all")
    @Transactional
    public ResponseEntity<AnswerRequests<Page<UserStoryGeneralDto>>> getUserStories(@RequestParam int page, @RequestParam int size) {
        AnswerRequests<Page<UserStoryGeneralDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("All User Story");

        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(this.userStoryReadService.getUserStories(pageable, this.authenticatedUser.getUser().getCompanyId()));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }

    /**
     * Handles a GET request to retrieve a paginated list of `UserStoryGeneralDto` objects for a specific project within the authenticated user's company.
     *
     * The method takes the `id` of the project as a path variable, along with pagination parameters (`page` and `size`) as request parameters.
     * It fetches the user stories associated with the given project ID and the company of the currently authenticated user.
     * The results are returned wrapped in an `AnswerRequests` object, which includes metadata about the success of the operation, a message, and the data itself.
     *
     * @param id the ID of the project for which user stories are to be retrieved.
     * @param page the page number for pagination.
     * @param size the size of each page.
     * @return a `ResponseEntity` containing an `AnswerRequests` object with the paginated list of `UserStoryGeneralDto`.
     */
    @GetMapping("projectId/{id}")
    @Transactional
    public ResponseEntity<AnswerRequests<Page<UserStoryGeneralDto>>> getUserStoryByProjectId(@PathVariable Long id, @RequestParam int page, @RequestParam int size) {
        AnswerRequests<Page<UserStoryGeneralDto>>answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("User Story");
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(this.userStoryReadService.getUserStoryByProjectId(
                id,
                this.authenticatedUser.getUser().getCompanyId(),
                pageable
        ));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }





}
