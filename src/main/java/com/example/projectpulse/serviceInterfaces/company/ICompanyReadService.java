package com.example.projectpulse.serviceInterfaces.company;

import com.example.projectpulse.dtos.company.read.GeneralCompanyDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;



public interface ICompanyReadService {

    Page<GeneralCompanyDto> getAllCompanies(Pageable pageable);
}
