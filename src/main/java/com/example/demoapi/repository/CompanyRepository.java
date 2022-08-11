package com.example.demoapi.repository;

import com.example.demoapi.entities.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class CompanyRepository {
    private final List<Company> companyList = new ArrayList<>();
    int id = 0;

    public CompanyRepository() {
        companyList.add(new Company(1, "AAA"));
        companyList.add(new Company(2, "BBB"));
        companyList.add(new Company(3, "CCC"));
        companyList.add(new Company(4, "EEE"));
        companyList.add(new Company(5, "DDD"));
        companyList.add(new Company(6, "FFF"));
        companyList.add(new Company(7, "PPP"));
        companyList.add(new Company(8, "LLL"));
        companyList.add(new Company(9, "QQQ"));
    }

    public List<Company> getAllCompanies() {
        return companyList;
    }

    public boolean createCompany(Company company) {
        id++;
        company.setId(id);
        companyList.add(company);
        return true;
    }

    public Company getCompanyById(Integer id) {
        final var companyStream = companyList.stream().filter(i -> i.getId().equals(id));
        return companyStream.findFirst().orElse(null);
    }

    public boolean deleteCompany(Integer id) {
        return companyList.remove(getCompanyById(id));
    }


}
