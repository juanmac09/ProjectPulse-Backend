package com.example.projectpulse.services.company;

import com.example.projectpulse.dtos.company.read.GeneralCompanyDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.mapping.company.GeneralCompanyMapper;
import com.example.projectpulse.repositories.company.CompanyRepository;
import com.example.projectpulse.serviceInterfaces.company.ICompanyReadService;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CompanyReadService implements ICompanyReadService {

    private final CompanyRepository companyRepository;
    private final GeneralCompanyMapper generalCompanyMapper;
    public CompanyReadService(CompanyRepository companyRepository , GeneralCompanyMapper generalCompanyMapper) {
        this.companyRepository = companyRepository;
        this.generalCompanyMapper = generalCompanyMapper;
    }

    @Transactional
    @Override
    public Page<GeneralCompanyDto> getAllCompanies(Pageable pageable) {
        Page<Company> companies = companyRepository.findAllByOrderByNameAsc(pageable);
        return companies.map(this.generalCompanyMapper::map);
    }
}
