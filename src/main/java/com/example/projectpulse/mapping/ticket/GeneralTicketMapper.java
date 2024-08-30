package com.example.projectpulse.mapping.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketGeneralDto;
import com.example.projectpulse.entities.Ticket;
import com.example.projectpulse.mapping.Mapper;
import com.example.projectpulse.mapping.userstory.GeneralUserStoryMapper;
import org.springframework.stereotype.Component;

@Component
public class GeneralTicketMapper implements Mapper<TicketGeneralDto, Ticket> {

    private final GeneralUserStoryMapper generalUserStoryMapper;
    public GeneralTicketMapper(GeneralUserStoryMapper generalUserStoryMapper) {
        this.generalUserStoryMapper = generalUserStoryMapper;
    }

    /**
     * Maps a Ticket entity to a TicketGeneralDto.
     *
     * @param ticket The Ticket entity to map.
     * @return A TicketGeneralDto representing the mapped Ticket, or null if the input is null.
     */
    @Override
    public TicketGeneralDto map(Ticket ticket) {
        if (ticket == null) return null;

        TicketGeneralDto ticketDto = new TicketGeneralDto();
        ticketDto.setId(ticket.getId());
        ticketDto.setTitle(ticket.getTitle());
        ticketDto.setDescription(ticket.getDescription());
        ticketDto.setStatus(ticket.getStatus());
        ticketDto.setComment(ticket.getComments());
        ticketDto.setUserStory(this.generalUserStoryMapper.map(ticket.getUserStoryId()));

        return ticketDto;
    }

}
