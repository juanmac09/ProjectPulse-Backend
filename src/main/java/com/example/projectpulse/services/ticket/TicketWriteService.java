package com.example.projectpulse.services.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketGeneralDto;
import com.example.projectpulse.dtos.ticket.write.TicketCreateDto;
import com.example.projectpulse.dtos.ticket.write.TicketUpdateDto;
import com.example.projectpulse.entities.Ticket;
import com.example.projectpulse.exception.ticket.TicketNotFoundException;
import com.example.projectpulse.mapping.ticket.GeneralTicketMapper;
import com.example.projectpulse.repositories.ticket.TicketRepository;
import com.example.projectpulse.serviceInterfaces.ticket.ITicketWriteService;
import org.springframework.stereotype.Service;

@Service
public class TicketWriteService implements ITicketWriteService {

    private final TicketRepository ticketRepository;
    private final GeneralTicketMapper generalTicketMapper;

    public TicketWriteService(TicketRepository ticketRepository, GeneralTicketMapper generalTicketMapper) {
        this.ticketRepository = ticketRepository;
        this.generalTicketMapper = generalTicketMapper;
    }

    /**
     * Creates a new Ticket based on the provided TicketCreateDto and saves it to the repository.
     *
     * @param ticket The DTO containing the details for the new Ticket.
     * @return A TicketGeneralDto representing the saved Ticket.
     */
    @Override
    public TicketGeneralDto createTicket(TicketCreateDto ticket) {
        Ticket ticketEntity = new Ticket();
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setDescription(ticket.getDescription());
        ticketEntity.setStatus(ticket.getStatus());
        ticketEntity.setComments(ticket.getComment());
        ticketEntity.setUserStoryId(ticket.getUserStory());
        return this.generalTicketMapper.map(this.ticketRepository.save(ticketEntity));
    }

    /**
     * Updates an existing Ticket with the provided details and saves the changes.
     *
     * @param id The ID of the Ticket to update.
     * @param ticket The DTO containing the updated details for the Ticket.
     * @return A TicketGeneralDto representing the updated Ticket.
     * @throws TicketNotFoundException if the Ticket with the specified ID is not found.
     */
    @Override
    public TicketGeneralDto updateTicket(Long id, TicketUpdateDto ticket) throws TicketNotFoundException {
        Ticket ticketEntity = this.ticketRepository.findById(id).orElse(null);
        if (ticketEntity == null) throw new TicketNotFoundException("Ticket not found");

        if (ticket.getTitle() != null) ticketEntity.setTitle(ticket.getTitle());
        if (ticket.getDescription() != null) ticketEntity.setDescription(ticket.getDescription());
        if (ticket.getStatus() != null) ticketEntity.setStatus(ticket.getStatus());
        if (ticket.getComment() != null) ticketEntity.setComments(ticket.getComment());

        return this.generalTicketMapper.map(this.ticketRepository.save(ticketEntity));
    }

}
