package com.example.demoapi.service;

import com.example.demoapi.entities.Company;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.CompanyRepository;
import com.example.demoapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    private final EmployeeRepository employeeRepository;

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
        oldCompany.setCompanyName(company.getCompanyName().isEmpty() ? oldCompany.getCompanyName() : company.getCompanyName());
        return oldCompany;
    }

    public Company addEmployeeToCompany(Integer companyId, Integer employeeId) {
        Company company = companyRepository.getCompanyById(companyId);
        Employee employee = employeeRepository.getEmployeeById(employeeId);
        company.getEmployeeList().add(employee);
        return company;
    }

    public List<Employee> getEmployeeByCompany(Integer companyId) {
        Company company = companyRepository.getCompanyById(companyId);
        List<Employee> employeeList = company.getEmployeeList();
        return employeeList;
    }

    public List<Company> getCurrentPageCompany(int pageNumber, Integer pageSize) {
        int realPageNumber = --pageNumber;
        final var allCompanies = companyRepository.getAllCompanies();
        List<Company> currentPageCompany = new ArrayList<>();
        final var endNumberOfRequiredCompanyPage = realPageNumber * pageSize + pageSize;
        var startNumberOfRequiredCompanyPage = realPageNumber * pageSize;
        if (endNumberOfRequiredCompanyPage < allCompanies.size()) {
            for (int i = startNumberOfRequiredCompanyPage; i < endNumberOfRequiredCompanyPage; i++) {
                currentPageCompany.add(allCompanies.get(i));
            }
        }
        return currentPageCompany;
    }
}
