package com.example.projectpulse.mapping.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketSpecificDto;
import com.example.projectpulse.entities.Ticket;
import com.example.projectpulse.mapping.Mapper;
import org.springframework.stereotype.Component;

@Component
public class SpecificTicketMapper implements Mapper<TicketSpecificDto, Ticket> {

    /**
     * Converts a Ticket entity into a TicketSpecificDto.
     *
     * @param ticket The Ticket entity to be converted.
     * @return A TicketSpecificDto representing the Ticket, or null if the input Ticket is null.
     */
    @Override
    public TicketSpecificDto map(Ticket ticket) {
        if (ticket == null) return null;

        TicketSpecificDto ticketSpecificDto = new TicketSpecificDto();
        ticketSpecificDto.setId(ticket.getId());
        ticketSpecificDto.setTitle(ticket.getTitle());
        ticketSpecificDto.setDescription(ticket.getDescription());
        ticketSpecificDto.setStatus(ticket.getStatus());
        ticketSpecificDto.setComment(ticket.getComments());

        return ticketSpecificDto;
    }

}
