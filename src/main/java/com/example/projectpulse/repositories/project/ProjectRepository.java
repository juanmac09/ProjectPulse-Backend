package com.example.projectpulse.repositories.project;

import com.example.projectpulse.entities.Company;
import com.example.projectpulse.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface  ProjectRepository extends JpaRepository<Project, Long> {
    Project findByIdAndCompanyId(Long id, Company companyId);
    Page<Project> findAllByCompanyId(Company companyId,Pageable pageable);
    @Query("SELECT p FROM Project p WHERE p.companyId.id = :companyId AND (p.name LIKE %:searchTerm% OR p.description LIKE %:searchTerm%)")
    Page<Project> searchProjectsByCompany(@Param("companyId") Long companyId, @Param("searchTerm") String searchTerm, Pageable pageable);
}
