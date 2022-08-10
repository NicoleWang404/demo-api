package com.example.demoapi.service;

import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmplpyee();
    }

    public boolean createEmployee(Employee employee) {

        return employeeRepository.createEmployee(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.getEmployeeById(id);
    }

    public boolean deleteEmployee(Integer id) {
        return employeeRepository.deleteEmployee(id);
    }

    public Employee updateEmployee(Integer id, Employee employee) {
        Employee oldEmployee = employeeRepository.getEmployeeById(id);
        Employee temp = employeeRepository.getEmployeeById(id);
        temp.setAge(employee.getAge() == null ? oldEmployee.getAge():employee.getAge());
        temp.setGender(employee.getGender().isEmpty() ? oldEmployee.getGender():employee.getGender());
        temp.setName(employee.getName().isEmpty() ? oldEmployee.getName():employee.getName());
        return employeeRepository.getEmployeeById(id);
    }

}
