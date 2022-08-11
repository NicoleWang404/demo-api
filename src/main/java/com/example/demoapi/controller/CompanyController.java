package com.example.demoapi.controller;

import com.example.demoapi.entities.Company;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping

    public List<Company> getCompanies() {
        return companyService.getAllCompanies();
    }

    @PostMapping
    public boolean addCompany(@RequestBody Company company) {
        return companyService.createCompany(company); //post有请求体 get没有
    }

    @GetMapping(value = "/{id}")

    public Company getCompany(@PathVariable(value = "id") Integer id) {
        return companyService.getCompanyById(id);

    }

    @PutMapping(value = "/{id}")

    public Company updateCompany(@PathVariable(value = "id") Integer id, @RequestBody Company company) {
        return companyService.updateCompany(id, company);
    }

    @DeleteMapping(value = "/{id}")

    public boolean deleteCompany(@PathVariable(value = "id") Integer id) {
        return companyService.deleteCompany(id);
    }

    // TODO: 2022/8/10 how to deal with the scenario when add duplicate employee to company
    // TODO: 2022/8/10 how to deal with the scenario when add employee that not exists to company
    // TODO: 2022/8/10 how to deal with the scenario when add employee to company that not exists
    // TODO: 2022/8/10 how to judge whether the employee has already been hired to another company
    @PutMapping(value = "/{companyId}/employees/{id}")
    public Company addEmployeeToCompany(@PathVariable(value = "companyId") Integer companyId, @PathVariable(value = "id") Integer employeeId) {
        return companyService.addEmployeeToCompany(companyId, employeeId);
    }

    @GetMapping(value = "/{id}/employees/")
    public List<Employee> getEmployeeByCompany(@PathVariable(value = "id") Integer id) {
        return companyService.getEmployeeByCompany(id);
    }

    @GetMapping("/page/{pageNumber}/pageSize/{pageSize}")
    public List<Company> getCompanyInfoByPage(@PathVariable Integer pageNumber,@PathVariable Integer pageSize) {
        return companyService.getCurrentPageCompany(pageNumber,pageSize);
    }

}



