package com.example.projectpulse.controllers.tickets;

import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.auth.read.AuthenticatedUser;
import com.example.projectpulse.dtos.ticket.read.TicketSpecificDto;
import com.example.projectpulse.enums.ticket.Status;
import com.example.projectpulse.serviceInterfaces.ticket.ITicketReadService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketReadController {

    private final ITicketReadService ticketReadService;
    private final AuthenticatedUser authenticatedUser;

    public TicketReadController(ITicketReadService ticketReadService, AuthenticatedUser authenticatedUser) {
        this.ticketReadService = ticketReadService;
        this.authenticatedUser = authenticatedUser;
    }

    /**
     * Handles HTTP GET requests to retrieve a specific Ticket by its ID for the authenticated user's company.
     *
     * @param id The ID of the Ticket to retrieve.
     * @return A ResponseEntity containing an AnswerRequests object with the Ticket details, success status, and a message (null if not set).
     */
    @Transactional
    @GetMapping("/{id}")
    public ResponseEntity<AnswerRequests<TicketSpecificDto>> getTicket(@PathVariable Long id) {
        AnswerRequests<TicketSpecificDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        answerRequests.setData(this.ticketReadService.getTicket(id, this.authenticatedUser.getUser().getCompanyId()));

        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }

    /**
     * Handles HTTP GET requests to retrieve tickets filtered by status and associated with a specific User Story.
     *
     * @param userStoryId The ID of the User Story to filter tickets by.
     * @param status The status of the tickets to retrieve, represented as an integer index.
     * @param page The page number to retrieve.
     * @param size The number of tickets per page.
     * @return A ResponseEntity containing an AnswerRequests object with a paginated list of tickets, success status, and a message (null if not set).
     */
    @Transactional
    @GetMapping("/get/statusAndUserStory/{userStoryId}")
    public ResponseEntity<AnswerRequests<Page<TicketSpecificDto>>> getTicketStatusAndUserStory(
            @PathVariable("userStoryId") Long userStoryId,
            @RequestParam("status") int status,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        AnswerRequests<Page<TicketSpecificDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(
                this.ticketReadService.getTicketsByStatusAndUserStory(
                        Status.fromIndex(status),
                        userStoryId,
                        this.authenticatedUser.getUser().getCompanyId(),
                        pageable
                )
        );
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Handles HTTP GET requests to retrieve all tickets for the authenticated user's company with pagination.
     *
     * @param page The page number to retrieve.
     * @param size The number of tickets per page.
     * @return A ResponseEntity containing an AnswerRequests object with a paginated list of all tickets, success status, and a message (null if not set).
     */
    @Transactional
    @GetMapping("/get/all")
    public ResponseEntity<AnswerRequests<Page<TicketSpecificDto>>> getAllTickets(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        AnswerRequests<Page<TicketSpecificDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(
                this.ticketReadService.getTicketsByCompanyId(
                        this.authenticatedUser.getUser().getCompanyId(),
                        pageable
                )
        );
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Handles HTTP GET requests to retrieve tickets associated with a specific project with pagination.
     *
     * @param projectId The ID of the project to filter tickets by.
     * @param page The page number to retrieve.
     * @param size The number of tickets per page.
     * @return A ResponseEntity containing an AnswerRequests object with a paginated list of tickets associated with the project, success status, and a message (null if not set).
     */
    @Transactional
    @GetMapping("/get/project/{projectId}")
    public ResponseEntity<AnswerRequests<Page<TicketSpecificDto>>> getTicketProject(
            @PathVariable("projectId") Long projectId,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        AnswerRequests<Page<TicketSpecificDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(
                this.ticketReadService.getTicketsByProjectId(
                        projectId,
                        this.authenticatedUser.getUser().getCompanyId(),
                        pageable
                )
        );
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Handles HTTP GET requests to retrieve tickets filtered by both project ID and status with pagination.
     *
     * @param projectId The ID of the project to filter tickets by.
     * @param status The status of the tickets to retrieve, represented as an integer index.
     * @param page The page number to retrieve.
     * @param size The number of tickets per page.
     * @return A ResponseEntity containing an AnswerRequests object with a paginated list of tickets filtered by project ID and status, success status, and a message (null if not set).
     */
    @Transactional
    @GetMapping("/get/projectAndStatus/{projectId}")
    public ResponseEntity<AnswerRequests<Page<TicketSpecificDto>>> getTicketProjectAndStatus(
            @PathVariable("projectId") Long projectId,
            @RequestParam("status") int status,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        AnswerRequests<Page<TicketSpecificDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(
                this.ticketReadService.getTicketsByProjectIdAndStatus(
                        projectId,
                        Status.fromIndex(status),
                        this.authenticatedUser.getUser().getCompanyId(),
                        pageable
                )
        );
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


    /**
     * Handles a GET request to retrieve a paginated list of `TicketSpecificDto` objects for a specific user story.
     * The method takes the `userStoryId` as a path variable and pagination parameters (`page` and `size`) as
     * request parameters. It fetches the tickets associated with the given user story ID within the company of
     * the currently authenticated user. The results are returned wrapped in an `AnswerRequests` object, which
     * includes metadata about the success of the operation and the data itself.
     *
     * @param userStoryId the ID of the user story for which tickets are to be retrieved.
     * @param page the page number for pagination.
     * @param size the size of each page.
     * @return a `ResponseEntity` containing an `AnswerRequests` object with the paginated list of `TicketSpecificDto`.
     */
    @Transactional
    @GetMapping("/get/UserStory/{userStoryId}")
    public ResponseEntity<AnswerRequests<Page<TicketSpecificDto>>> getTicketByUserStory(
            @PathVariable("userStoryId") Long userStoryId,
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        AnswerRequests<Page<TicketSpecificDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage(null);
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(
                this.ticketReadService.getTicketsByUserStory(
                        userStoryId,
                        this.authenticatedUser.getUser().getCompanyId(),
                        pageable
                )
        );
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


}
