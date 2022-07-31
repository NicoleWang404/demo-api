package com.example.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)

    public List<Company> getCompanies() {
        return companyService.getAllCompanies();
    }

    @RequestMapping(value = "/companies", method = RequestMethod.POST)

    public boolean addCompany(@RequestBody Company company) {
        return companyService.createCompany(company); //post有请求体 get没有
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)

    public Company getCompany(@PathVariable(value = "id") Integer id) {
        return companyService.getCompany(id);

    }

//    @RequestMapping(value = "/companies/{id}", method = RequestMethod.PUT)
//
//    public Company updateCompany(@PathVariable(value = "id") Company company) {
//        return companyService.updateById();

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.DELETE)

    public boolean deleteCompany(@PathVariable(value = "id") Integer id) {
        return companyService.deleteCompany(id);
    }
}



