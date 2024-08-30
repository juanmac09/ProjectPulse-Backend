package com.example.projectpulse.controllers.tickets;

import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.ticket.read.TicketGeneralDto;
import com.example.projectpulse.dtos.ticket.write.TicketCreateDto;
import com.example.projectpulse.dtos.ticket.write.TicketUpdateDto;
import com.example.projectpulse.serviceInterfaces.ticket.ITicketWriteService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    private final ITicketWriteService ticketService;

    public TicketController(ITicketWriteService ticketService) {
        this.ticketService = ticketService;
    }


    /**
     * Handles HTTP POST requests to create a new Ticket.
     *
     * @param ticketCreateDto The DTO containing the details for the new Ticket. It must be valid.
     * @return A ResponseEntity containing an AnswerRequests object with the created Ticket details, success status, and a message.
     */
    @Transactional
    @PostMapping("/create")
    public ResponseEntity<AnswerRequests<TicketGeneralDto>> createTicket(@Valid @RequestBody TicketCreateDto ticketCreateDto) {
        AnswerRequests<TicketGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("Ticket created successfully");
        answerRequests.setData(this.ticketService.createTicket(ticketCreateDto));
        return new ResponseEntity<>(answerRequests, HttpStatus.CREATED);
    }


    /**
     * Handles HTTP PUT requests to update an existing Ticket.
     *
     * @param id The ID of the Ticket to update.
     * @param ticketUpdateDto The DTO containing the updated details for the Ticket. It must be valid.
     * @return A ResponseEntity containing an AnswerRequests object with the updated Ticket details, success status, and a message.
     */
    @Transactional
    @PutMapping("/update/{id}")
    public ResponseEntity<AnswerRequests<TicketGeneralDto>> updateTicket(@PathVariable("id") Long id, @Valid @RequestBody TicketUpdateDto ticketUpdateDto) {
        AnswerRequests<TicketGeneralDto> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("Ticket created successfully");
        answerRequests.setData(this.ticketService.updateTicket(id, ticketUpdateDto));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }


}
