package com.example.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
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

    public void addCompany(@RequestBody Company company) {
        companyService.createCompany(company); //post有请求体 get没有
    }

    @RequestMapping(value = "/companies/{id}", method = RequestMethod.GET)

    public Company getCompany(@PathVariable(value="id") Integer id) {
        return companyService.getCompany(id);

    }
}



