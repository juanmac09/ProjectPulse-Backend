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





}
