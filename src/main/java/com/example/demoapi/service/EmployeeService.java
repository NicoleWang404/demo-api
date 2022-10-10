package com.example.demoapi.service;

import com.example.demoapi.dto.EmployeeCreateDTO;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    
    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee saveEmployee(EmployeeCreateDTO employeeCreateDTO){
        Employee employee = Employee.builder()
                .age(employeeCreateDTO.getAge())
                .name(employeeCreateDTO.getName())
                .gender(employeeCreateDTO.getGender()).build();
        return employeeRepo.save(employee);
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepo.findById(id).get();
    }

    public void deleteEmployee(Integer id) {
         employeeRepo.deleteById(id);
    }



    public Employee updateEmployee(Integer id, Employee employee) {
        employee.setId(id);
        return employeeRepo.save(employee);
    }
    public List<Employee> getEmployeeByGender(String gender) {
        return employeeRepo.findAllByGender(gender);
    }

}
