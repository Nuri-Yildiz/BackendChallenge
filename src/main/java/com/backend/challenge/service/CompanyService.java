package com.backend.challenge.service;

import com.backend.challenge.entity.Company;
import com.backend.challenge.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    public List<Company> addCompany(Company company){
        Company companyEntity = new Company();
        companyEntity.setCompanyName(company.getCompanyName());
        companyRepository.save((companyEntity));
        return companyRepository.findAll();
    }

    public List<Company> deleteCompany(Long companyId){
        companyRepository.delete(companyRepository.findById(companyId).get());
        return companyRepository.findAll();
    }

    public List<Company> getCompanyList(){
        return companyRepository.findAll();
    }

}
