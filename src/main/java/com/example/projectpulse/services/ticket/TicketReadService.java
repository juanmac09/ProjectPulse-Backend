package com.example.projectpulse.services.ticket;

import com.example.projectpulse.dtos.ticket.read.TicketSpecificDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.entities.Ticket;
import com.example.projectpulse.enums.ticket.Status;
import com.example.projectpulse.mapping.ticket.SpecificTicketMapper;
import com.example.projectpulse.repositories.ticket.TicketReadRepository;
import com.example.projectpulse.serviceInterfaces.ticket.ITicketReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketReadService implements ITicketReadService {

    private final TicketReadRepository ticketReadRepository;
    private final SpecificTicketMapper specificTicketMapper;

    public TicketReadService(TicketReadRepository ticketReadRepository, SpecificTicketMapper specificTicketMapper) {
        this.ticketReadRepository = ticketReadRepository;
        this.specificTicketMapper = specificTicketMapper;
    }

    /**
     * Retrieves a Ticket by its ID for a specific company and maps it to a TicketSpecificDto.
     *
     * @param id The ID of the Ticket to retrieve.
     * @param company The company for which to retrieve the Ticket.
     * @return A TicketSpecificDto representing the Ticket, or null if the Ticket is not found.
     */
    @Override
    public TicketSpecificDto getTicket(Long id, Company company) {
        Ticket ticket = ticketReadRepository.findByIdAndCompanyId(id, company.getId());
        if (ticket == null) return null;

        return this.specificTicketMapper.map(ticket);
    }


    /**
     * Retrieves a paginated list of tickets filtered by status and associated with a specific User Story for a given company.
     *
     * @param status The status of the tickets to retrieve.
     * @param userStoryId The ID of the User Story to filter tickets by.
     * @param company The company for which to retrieve tickets.
     * @param pageable Pagination information (page number and page size).
     * @return A Page of TicketSpecificDto objects representing the tickets matching the criteria.
     */
    @Override
    public Page<TicketSpecificDto> getTicketsByStatusAndUserStory(Status status, Long userStoryId, Company company, Pageable pageable){
        Page<Ticket> tickets = this.ticketReadRepository.findByStatusAndUserStoryIdAndCompanyId(status, userStoryId, company.getId(), pageable);
        return tickets.map(this.specificTicketMapper::map);
    }


    /**
     * Retrieves a paginated list of all tickets for a given company.
     *
     * @param company The company for which to retrieve tickets.
     * @param pageable Pagination information (page number and page size).
     * @return A Page of TicketSpecificDto objects representing all tickets for the company.
     */
    @Override
    public Page<TicketSpecificDto> getTicketsByCompanyId(Company company, Pageable pageable){
        Page<Ticket> tickets = this.ticketReadRepository.findAllByCompanyId(company.getId(), pageable);
        return tickets.map(this.specificTicketMapper::map);
    }


    /**
     * Retrieves a paginated list of tickets associated with a specific project for a given company.
     *
     * @param projectId The ID of the project to filter tickets by.
     * @param company The company for which to retrieve tickets.
     * @param pageable Pagination information (page number and page size).
     * @return A Page of TicketSpecificDto objects representing the tickets associated with the project.
     */
    @Override
    public Page<TicketSpecificDto> getTicketsByProjectId(Long projectId, Company company, Pageable pageable){
        Page<Ticket> tickets = this.ticketReadRepository.findAllByProjectIdAndCompanyId(projectId, company.getId(), pageable);
        return tickets.map(this.specificTicketMapper::map);
    }


    /**
     * Retrieves a paginated list of tickets filtered by both project ID and status for a given company.
     *
     * @param projectId The ID of the project to filter tickets by.
     * @param status The status of the tickets to retrieve.
     * @param company The company for which to retrieve tickets.
     * @param pageable Pagination information (page number and page size).
     * @return A Page of TicketSpecificDto objects representing the tickets matching the project ID and status.
     */
    @Override
    public Page<TicketSpecificDto> getTicketsByProjectIdAndStatus(Long projectId, Status status, Company company, Pageable pageable){
        Page<Ticket> tickets = this.ticketReadRepository.findAllByProjectIdAndCompanyIdAndStatus(projectId, company.getId(), status, pageable);
        return tickets.map(this.specificTicketMapper::map);
    }

    /**
     * Retrieves a paginated list of `TicketSpecificDto` objects for a specific user story within a company.
     *
     * This method first queries the `TicketReadRepository` to find `Ticket` entities based on the provided
     * `userStoryId` and `company` parameters, using pagination. Then, it maps the resulting `Ticket` entities
     * to `TicketSpecificDto` objects using the `specificTicketMapper`.
     *
     * @param userStoryId the ID of the user story for which tickets are to be retrieved.
     * @param company the company to which the tickets should belong.
     * @param pageable the pagination information.
     * @return a paginated list of `TicketSpecificDto` objects.
     */
    @Override
    public Page<TicketSpecificDto> getTicketsByUserStory(Long userStoryId, Company company, Pageable pageable) {
        Page<Ticket> tickets = this.ticketReadRepository.findByUserStoryIdAndCompanyId(userStoryId, company.getId(), pageable);
        return tickets.map(this.specificTicketMapper::map);
    }
}
