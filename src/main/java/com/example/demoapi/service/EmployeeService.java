package com.example.demoapi.service;

import com.example.demoapi.dto.EmployeeCreateDTO;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.EmployeeRepo;
import com.example.demoapi.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeRepo employeeRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public boolean createEmployee(Employee employee) {
        return employeeRepository.createEmployee(employee);
    }

    public Employee saveEmployee(EmployeeCreateDTO employeeCreateDTO){
        Employee employee = Employee.builder()
                .age(employeeCreateDTO.getAge())
                .name(employeeCreateDTO.getName())
                .gender(employeeCreateDTO.getGender()).build();
        return employeeRepo.save(employee);
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
        temp.setGender(Objects.isNull(employee.getGender()) ? oldEmployee.getGender():employee.getGender());
        temp.setName(employee.getName().isEmpty() ? oldEmployee.getName():employee.getName());
        return employeeRepository.getEmployeeById(id);
    }
    public Employee getEmployeeByGender(String gender) {
        return employeeRepository.getEmployeeByGender(gender);
    }

}
