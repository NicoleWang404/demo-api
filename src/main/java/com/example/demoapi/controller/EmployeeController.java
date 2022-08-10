package com.example.demoapi.controller;

import com.example.demoapi.entities.Employee;
import com.example.demoapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor //给带final的变量构造函数
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(value = "/employees")

    public List<Employee> getEmployee() {
        return employeeService.getAllEmployee();
    }

    @PostMapping

    public void addEmployee(@RequestBody Employee employee) {
        employeeService.createEmployee(employee); //post有请求体 get没有
    }

    @GetMapping(value = "{id}")

    public Employee getCompany(@PathVariable(value="id") Integer id) {
        return employeeService.getEmployeeById(id);

    }
    @DeleteMapping(value ="{id}")
    public boolean deleteEmployee(@PathVariable(value="id") Integer id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "{id}")
    public Employee updateEmployee(@PathVariable(value="id")Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id,employee);
    }

}



