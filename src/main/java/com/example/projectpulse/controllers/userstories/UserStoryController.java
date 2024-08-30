package com.example.projectpulse.controllers.userstories;


import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.userstory.read.UserStoryGeneralDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryCreateDto;
import com.example.projectpulse.dtos.userstory.write.UserStoryUpdatedDto;
import com.example.projectpulse.services.userstory.UserStoryWriteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user-story")
public class UserStoryController {

    private final UserStoryWriteService userStoryWriteService;

    public UserStoryController(UserStoryWriteService userStoryWriteService) {
        this.userStoryWriteService = userStoryWriteService;
    }


    /**
     * Handles HTTP POST requests to create a new UserStory.
     *
     * @param userStoryDto The DTO containing the details for the new UserStory. It must be valid.
     * @return A ResponseEntity containing an AnswerRequests object with the created UserStory, success status, and a message.
     */
    @Transactional
    @PostMapping("/create")
    public ResponseEntity<AnswerRequests<UserStoryGeneralDto>> createUserStory(@Valid @RequestBody UserStoryCreateDto userStoryDto) {
        AnswerRequests<UserStoryGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("UserStory created successfully");
        answerRequests.setData(this.userStoryWriteService.create(userStoryDto));
        return new ResponseEntity<AnswerRequests<UserStoryGeneralDto>>(answerRequests, HttpStatus.CREATED);
    }

    /**
     * Handles HTTP PUT requests to update an existing UserStory.
     *
     * @param id The ID of the UserStory to update.
     * @param userStoryUpdatedDto The DTO containing the updated details of the UserStory. It must be valid.
     * @return A ResponseEntity containing an AnswerRequests object with the updated UserStory, success status, and a message.
     */
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity<AnswerRequests<UserStoryGeneralDto>> updateUserStory(@NotNull @PathVariable("id") Long id, @Valid @RequestBody UserStoryUpdatedDto userStoryUpdatedDto) {
        AnswerRequests<UserStoryGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("UserStory updated successfully");
        answerRequests.setData(this.userStoryWriteService.update(id, userStoryUpdatedDto));
        return new ResponseEntity<AnswerRequests<UserStoryGeneralDto>>(answerRequests, HttpStatus.OK);
    }


}
