package com.example.demoapi.repository;

import com.example.demoapi.entities.Company;
import com.example.demoapi.entities.Employee;
import lombok.val;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository

public class CompanyRepository {
    private final List<Company> companyList = new ArrayList<>();

    ArrayList<Employee> employeeList = new ArrayList<>();

    int id = 0;

    public CompanyRepository() {
        employeeList.add(new Employee(1, "aaa", 22, "male"));
        companyList.add(new Company(1, "AAA", employeeList));
        companyList.add(new Company(2, "BBB", employeeList));
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
