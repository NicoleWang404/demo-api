package com.example.demoapi.controller;

import com.example.demoapi.entities.Company;
import com.example.demoapi.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
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
        return companyService.updateCompany(id,company);
    }

    @DeleteMapping (value = "{id}")

    public boolean deleteCompany(@PathVariable(value = "id") Integer id) {
        return companyService.deleteCompany(id);
   }
}



