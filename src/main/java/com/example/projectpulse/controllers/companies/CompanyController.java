package com.example.projectpulse.controllers.companies;

import com.example.projectpulse.common.responses.AnswerRequests;
import com.example.projectpulse.dtos.company.read.GeneralCompanyDto;
import com.example.projectpulse.serviceInterfaces.company.ICompanyReadService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Controller for handling requests related to companies.
@RestController
@RequestMapping("/company")
public class CompanyController {

    private final ICompanyReadService companyReadService;
    public CompanyController(ICompanyReadService companyReadService) {
        this.companyReadService = companyReadService;
    }

    /**
     * Retrieves a paginated list of all companies.
     *
     * @param page The page number to retrieve (0-based index).
     * @param size The number of companies per page.
     * @return A ResponseEntity containing an AnswerRequests object with the paginated list of companies.
     */
    @GetMapping("/all")
    public ResponseEntity<AnswerRequests<Page<GeneralCompanyDto>>> all(@RequestParam int page, @RequestParam int size) {
        AnswerRequests<Page<GeneralCompanyDto>> answerRequests = new AnswerRequests<>();
        answerRequests.setSuccess(true);
        answerRequests.setMessage("Get All Company");
        Pageable pageable = PageRequest.of(page, size);
        answerRequests.setData(this.companyReadService.getAllCompanies(pageable));
        return new ResponseEntity<>(answerRequests, HttpStatus.OK);
    }
}
