package com.example.projectpulse.repositories.company;

import com.example.projectpulse.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CompanyRepository  extends JpaRepository<Company, Long> {
    Page<Company> findAllByOrderByNameAsc(Pageable pageable);
}
