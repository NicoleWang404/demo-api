package com.example.demoapi.controller;

import com.example.demoapi.dto.EmployeeCreateDTO;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;
// 1. use DTO instead of entity when transfer in controller
// 2. use @Valid and constraint annotation (e.g: @NotNull)
// 3. use ExceptionHandler to handle exception
// 4. use @Entity annotation to save in DB
// 5. use @Id for identity, and don't need to transfer id in DTO
@RestController
@RequestMapping(value = "/employees")
@RequiredArgsConstructor //给带final的变量构造函数
public class EmployeeController {

    @Resource
    private final EmployeeService employeeService;

    @GetMapping

    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

//    @PostMapping
//    public void addEmployee(@RequestBody Employee employee) {
//        employeeService.createEmployee(employee); //post有请求体 get没有
//    }

    @PostMapping("/add")
    public Employee createEmployee(@RequestBody @Valid EmployeeCreateDTO employeeCreateDTO){
        return employeeService.saveEmployee(employeeCreateDTO);
    }

    @GetMapping(value = "{id}")

    public Employee getEmployeeById(@PathVariable(value = "id") Integer id) {
        return employeeService.getEmployeeById(id);

    }

    @DeleteMapping(value = "{id}")
    public void deleteEmployee(@PathVariable(value = "id") Integer id) {
         employeeService.deleteEmployee(id);
    }

    @PutMapping(value = "{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Integer id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @GetMapping(value = "{gender}")
    public List<Employee> getEmployeeByGender(@PathVariable(value = "gender") String gender) {
        return  employeeService.getEmployeeByGender(gender);
    }


}



