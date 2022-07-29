package com.example.demoapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)

    public List<Employee> getEmployee() {
        return employeeService.getAllEmployee();
    }

    @RequestMapping(value = "/employees", method = RequestMethod.POST)

    public void addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee); //post有请求体 get没有
    }

    @RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)

    public Employee getCompany(@PathVariable(value="id") Integer id) {
        return employeeService.getEmployee(id);

    }
}



