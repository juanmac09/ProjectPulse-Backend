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

    // Constructor for dependency injection.
    public CompanyReadService(CompanyRepository companyRepository, GeneralCompanyMapper generalCompanyMapper) {
        this.companyRepository = companyRepository;
        this.generalCompanyMapper = generalCompanyMapper;
    }

    /**
     * Retrieves a paginated list of companies and maps them to GeneralCompanyDto.
     *
     * @param pageable The Pageable object containing pagination information.
     * @return A Page of GeneralCompanyDto objects.
     */
    @Transactional
    @Override
    public Page<GeneralCompanyDto> getAllCompanies(Pageable pageable) {
        Page<Company> companies = companyRepository.findAllByOrderByNameAsc(pageable);
        return companies.map(this.generalCompanyMapper::map);
    }
}
