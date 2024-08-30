package com.example.projectpulse.serviceInterfaces.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketGeneralDto;
import com.example.projectpulse.dtos.ticket.write.TicketCreateDto;
import com.example.projectpulse.dtos.ticket.write.TicketUpdateDto;

public interface ITicketWriteService {

    TicketGeneralDto createTicket(TicketCreateDto ticket);
    TicketGeneralDto updateTicket(Long id,TicketUpdateDto ticket);
}
