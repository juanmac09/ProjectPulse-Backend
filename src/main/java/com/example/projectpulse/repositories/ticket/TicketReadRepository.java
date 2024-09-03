package com.example.projectpulse.repositories.ticket;

import com.example.projectpulse.entities.Ticket;
import com.example.projectpulse.enums.ticket.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TicketReadRepository extends JpaRepository<Ticket, Long> {

    /**
     * Finds a ticket by its ID and ensures it belongs to a specific company.
     *
     * @param ticketId The ID of the ticket.
     * @param companyId The ID of the company to which the ticket's project must belong.
     * @return The ticket if found, otherwise null.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE t.id = :ticketId AND c.id = :companyId")
    Ticket findByIdAndCompanyId(@Param("ticketId") Long ticketId, @Param("companyId") Long companyId);


    /**
     * Finds tickets by their status and ensures they belong to a specific user story and company.
     *
     * @param status The status of the ticket.
     * @param userStoryId The ID of the user story to which the ticket is related.
     * @param companyId The ID of the company to which the ticket's project must belong.
     * @return A list of tickets that match the criteria.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE t.status = :status AND us.id = :userStoryId AND c.id = :companyId")
    Page<Ticket> findByStatusAndUserStoryIdAndCompanyId(@Param("status") Status status,
                                                        @Param("userStoryId") Long userStoryId,
                                                        @Param("companyId") Long companyId,
                                                        Pageable pageable);

    /**
     * Finds all tickets belonging to a specific company.
     *
     * @param companyId The ID of the company to which the tickets' projects must belong.
     * @return A list of tickets that belong to the specified company.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE c.id = :companyId")
    Page<Ticket> findAllByCompanyId(@Param("companyId") Long companyId,
                                    Pageable pageable);


    /**
     * Finds all tickets belonging to a specific project and ensures the project belongs to a specific company.
     *
     * @param projectId The ID of the project to which the tickets belong.
     * @param companyId The ID of the company to which the project's tickets must belong.
     * @return A list of tickets that belong to the specified project and company.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE p.id = :projectId AND c.id = :companyId")
    Page<Ticket> findAllByProjectIdAndCompanyId(@Param("projectId") Long projectId, @Param("companyId") Long companyId,
                                                Pageable pageable);


    /**
     * Finds all tickets belonging to a specific project and ensures the project belongs to a specific company, filtered by ticket status.
     *
     * @param projectId The ID of the project to which the tickets belong.
     * @param companyId The ID of the company to which the project's tickets must belong.
     * @param status The status of the tickets to filter by.
     * @return A list of tickets that belong to the specified project, company, and status.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE p.id = :projectId AND c.id = :companyId AND t.status = :status")
    Page<Ticket> findAllByProjectIdAndCompanyIdAndStatus(@Param("projectId") Long projectId,
                                                         @Param("companyId") Long companyId,
                                                         @Param("status") Status status,
                                                         Pageable pageable);


    /**
     * Retrieves a paginated list of `Ticket` entities based on the given `userStoryId` and `companyId`
     * The query joins the `Ticket` entity with the `UserStory`, `Project`, and `Company` entities to filter
     * the results by the specified `userStoryId` and `companyId`.
     *
     * @param userStoryId the ID of the user story to filter tickets by.
     * @param companyId the ID of the company to filter tickets by.
     * @param pageable the pagination information.
     * @return a `Page` containing the filtered tickets.
     */
    @Query("SELECT t FROM Ticket t " +
            "JOIN UserStory us ON t.userStoryId.id = us.id " +
            "JOIN Project p ON us.project.id = p.id " +
            "JOIN Company c ON p.companyId.id = c.id " +
            "WHERE us.id = :userStoryId AND c.id = :companyId")
    Page<Ticket> findByUserStoryIdAndCompanyId(@Param("userStoryId") Long userStoryId,
                                               @Param("companyId") Long companyId,
                                               Pageable pageable);


}
