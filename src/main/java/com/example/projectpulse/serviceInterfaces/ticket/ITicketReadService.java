package com.example.projectpulse.serviceInterfaces.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketGeneralDto;
import com.example.projectpulse.dtos.ticket.read.TicketSpecificDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.enums.ticket.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITicketReadService {

    TicketSpecificDto getTicket(Long id, Company company);
    Page<TicketSpecificDto> getTicketsByStatusAndUserStory(Status status, Long userStoryId, Company company, Pageable pageable);
    Page<TicketSpecificDto> getTicketsByCompanyId(Company company, Pageable pageable);
    Page<TicketSpecificDto> getTicketsByProjectId(Long projectId,Company company, Pageable pageable);
    Page<TicketSpecificDto> getTicketsByProjectIdAndStatus(Long projectId, Status status, Company company, Pageable pageable);
}
