package com.example.projectpulse.repositories.userstory;

import com.example.projectpulse.entities.UserStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    /**
     * Retrieves a `UserStory` entity based on the user story ID and company ID.
     *
     * This query joins the `UserStory` with its associated `Project` and the `Company` to filter results by
     * the specified `companyId` and `id` (user story ID).
     *
     * @param id the ID of the user story to be retrieved.
     * @param companyId the ID of the company to which the user story should belong.
     * @return the `UserStory` entity that matches the provided company ID and user story ID.
     */
    @Query("SELECT us FROM UserStory us " +
            "JOIN us.project p " +
            "JOIN p.companyId c " +
            "WHERE c.id = :companyId " +
            "AND us.id = :id")
    UserStory findAllByCompanyIdAndUserStoryId(@Param("id") Long id, @Param("companyId") Long companyId);

    /**
     * Retrieves a paginated list of `UserStory` entities based on the company ID.
     *
     * This query joins the `UserStory` with its associated `Project` and the `Company` to filter results by
     * the specified `companyId`. The results are returned in a paginated format.
     *
     * @param companyId the ID of the company to which the user stories should belong.
     * @param pageable the pagination information.
     * @return a paginated list of `UserStory` entities that match the provided company ID.
     */
    @Query("SELECT us FROM UserStory us " +
            "JOIN us.project p " +
            "JOIN p.companyId c " +
            "WHERE c.id = :companyId")
    Page<UserStory> findAllByCompanyId(@Param("companyId") Long companyId, Pageable pageable);

    /**
     * Retrieves a `UserStory` entity based on the project ID and company ID.
     *
     * This query joins the `UserStory` with its associated `Project` and the `Company` to filter results by
     * the specified `companyId` and project ID.
     *
     * @param id the ID of the project to which the user story belongs.
     * @param companyId the ID of the company to which the user story should belong.
     * @return the  Page `UserStory` entity that matches the provided company ID and project ID.
     */
    @Query("SELECT us FROM UserStory us " +
            "JOIN us.project p " +
            "JOIN p.companyId c " +
            "WHERE c.id = :companyId " +
            "AND us.project.id = :id")
    Page<UserStory> findAllByCompanyIdAndProjectId(@Param("id") Long id, @Param("companyId") Long companyId, Pageable pageable);


}
