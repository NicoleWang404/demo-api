package com.example.demoapi.service;

import com.example.demoapi.dto.CompanyUpdateDTO;
import com.example.demoapi.entities.Company;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.CompanyRepo;
import com.example.demoapi.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CompanyService {
    @Resource
    private final EmployeeRepo employeeRepo;
    @Resource
    private final CompanyRepo companyRepo;

    public List<Company> getAllCompanies() {
        return companyRepo.findAll();
    }

    public Company addCompany(Company company) {
        company.getEmployees().forEach(employee -> employee.setCompany(company));
        return companyRepo.save(company);
    }

    public Company getCompanyById(Integer id) {
        return companyRepo.findById(id).get();
    }

    public void deleteCompany(Integer id) {
        companyRepo.deleteById(id);
    }

    public Company updateCompany(Integer id, CompanyUpdateDTO companyUpdateDTO) {
        Company oldCompany = companyRepo.findById(id).get();
        oldCompany.setCompanyName(companyUpdateDTO.getCompanyName().isEmpty() ? oldCompany.getCompanyName() : companyUpdateDTO.getCompanyName());
        oldCompany.setLocation(companyUpdateDTO.getLocation() == null ? oldCompany.getLocation() : companyUpdateDTO.getLocation());
        return oldCompany;
    }

    public List<Employee> getEmployeeByCompany(Integer id) {
        final var employees = companyRepo.findById(id).get().getEmployees();
        return employees;
    }

    public Page<Company> getCurrentPageCompany(Pageable pageable) {

        return companyRepo.findAll(pageable);
    }
}
