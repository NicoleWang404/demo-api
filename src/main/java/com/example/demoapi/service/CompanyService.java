package com.example.demoapi.service;

import com.example.demoapi.entities.Company;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demoapi.repository.CompanyRepository;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {


    private final CompanyRepository companyRepository;


    public List<Company> getAllCompanies() {
        return companyRepository.getAllCompanies();
    }

    public Boolean createCompany(Company company) {
        return companyRepository.createCompany(company); //save？
    }

    public Company getCompanyById(Integer id) {
        return companyRepository.getCompanyById(id);
    }

    public boolean deleteCompany(Integer id) {
        return companyRepository.deleteCompany(id);
    }

    public Company updateCompany(Integer id, Company company) {
        Company oldCompany = companyRepository.getCompanyById(id);
        Company temp = companyRepository.getCompanyById(id);
       temp.setCompanyName(company.getCompanyName().isEmpty() ? oldCompany.getCompanyName() : company.getCompanyName());
        final var replaceAll = Collections.replaceAll(companyRepository.getAllCompanies(), oldCompany, temp);
        return companyRepository.getCompanyById(id);
    }


}

