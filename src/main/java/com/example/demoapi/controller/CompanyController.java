package com.example.demoapi.controller;

import com.example.demoapi.dto.CompanyUpdateDTO;
import com.example.demoapi.entities.Company;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public Company addCompany(@RequestBody @Valid Company company) {
        return companyService.addCompany(company);
    }

    @GetMapping(value = "/{id}")

    public Company getCompany(@PathVariable(value = "id") Integer id) {
        return companyService.getCompanyById(id);
    }


    @PutMapping(value = "/{id}")
    public Company updateCompany(@PathVariable(value = "id") Integer id, @RequestBody CompanyUpdateDTO companyUpdateDTO) {
        return companyService.updateCompany(id, companyUpdateDTO);
    }

    @DeleteMapping(value = "/{id}")

    public void deleteCompany(@PathVariable(value = "id") Integer id) {
        companyService.deleteCompany(id);
    }


    @GetMapping(value = "/{id}/employees")
    public List<Employee> getEmployeeByCompany(@PathVariable(value = "id") Integer id) {
        return companyService.getEmployeeByCompany(id);
    }

    @GetMapping("/page")
    public Page<Company> getCompanyInfoByPage(@PageableDefault(page = 0, size = 5, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return companyService.getCurrentPageCompany(pageable);
    }

}



