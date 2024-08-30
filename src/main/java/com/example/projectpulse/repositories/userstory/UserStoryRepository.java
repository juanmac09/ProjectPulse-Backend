package com.example.projectpulse.repositories.userstory;

import com.example.projectpulse.entities.UserStory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserStoryRepository extends JpaRepository<UserStory, Long> {

    @Query("SELECT us FROM UserStory us " +
            "JOIN us.project p " +
            "JOIN p.companyId c " +
            "WHERE c.id = :companyId " +
            "AND us.id = :id")
    UserStory findAllByCompanyIdAndUserStoryId(@Param("id") Long id, @Param("companyId") Long companyId);
    @Query("SELECT us FROM UserStory us " +
            "JOIN us.project p " +
            "JOIN p.companyId c " +
            "WHERE c.id = :companyId ")
    Page<UserStory> findAllByCompanyId(@Param("companyId") Long companyId, Pageable pageable);

}
