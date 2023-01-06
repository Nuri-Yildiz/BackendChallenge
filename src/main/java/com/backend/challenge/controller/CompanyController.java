package com.backend.challenge.controller;

import com.backend.challenge.entity.Company;
import com.backend.challenge.entity.Employee;
import com.backend.challenge.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private final CompanyService companyService;

    @GetMapping("/getCompanies")
    public List<Company> getCompanies(){
        return companyService.getCompanyList();
    }

    @PostMapping("/addCompany")
    public List<Company> addCompany(@RequestBody Company company){
        return companyService.addCompany((company));
    }

    @DeleteMapping("/{companyId}")
    @ResponseBody
    public List<Company> deleteCompany(@PathVariable Long companyId){
        return companyService.deleteCompany(companyId);
    }
}
