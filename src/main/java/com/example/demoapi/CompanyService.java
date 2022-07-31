package com.example.demoapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CompanyService {

    private final Map<Integer, Company> companyMap = new HashMap<>();

    public CompanyService() {
        companyMap.put(1, new Company(1, "AAA", 22));
        companyMap.put(2, new Company(2, "BBB", 33));
    }

    public List<Company> getAllCompanies() {
        return new ArrayList<>(companyMap.values());
    }

    public boolean createCompany(Company company) {
        companyMap.put(company.getId(), company);
        return true;
    }

    public Company getCompany(Integer id) {
        return companyMap.get(id);
    }

    public boolean deleteCompany(Integer id) {
        companyMap.remove(id);
        return true;
    }


//    public Company updateById(Company company) {
//Company updateCompany = company.getId();
    }

