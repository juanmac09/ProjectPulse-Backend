package com.example.projectpulse.mapping.company;

import com.example.projectpulse.dtos.company.read.GeneralCompanyDto;
import com.example.projectpulse.entities.Company;
import com.example.projectpulse.mapping.Mapper;
import org.springframework.stereotype.Component;

@Component
public class GeneralCompanyMapper implements Mapper<GeneralCompanyDto, Company> {

    /**
     * Maps a Company entity to a GeneralCompanyDto.
     *
     * @param company The Company entity to map.
     * @return The mapped GeneralCompanyDto, or null if the input company is null.
     */
    @Override
    public GeneralCompanyDto map(Company company) {
        if (company == null) return null;
        GeneralCompanyDto generalCompanyDto = new GeneralCompanyDto();
        generalCompanyDto.setId(company.getId());
        generalCompanyDto.setName(company.getName());
        return generalCompanyDto;
    }
}
