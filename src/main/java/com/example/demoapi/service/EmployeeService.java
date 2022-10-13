package com.example.demoapi.service;

import com.example.demoapi.dto.EmployeeCreateDTO;
import com.example.demoapi.entities.Employee;
import com.example.demoapi.repository.CompanyRepo;
import com.example.demoapi.repository.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    private final CompanyRepo companyRepo;

    public List<Employee> getAllEmployee() {
        return employeeRepo.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    public Employee saveEmployee(EmployeeCreateDTO employeeCreateDTO) {
        Employee employee = Employee.builder()
                .age(employeeCreateDTO.getAge())
                .name(employeeCreateDTO.getName())
                .company(companyRepo.findById(employeeCreateDTO.getCompanyId()).orElseThrow(RuntimeException::new))
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
        Employee oldEmployee = employeeRepo.findById(id).orElseThrow(RuntimeException::new);
        oldEmployee.setName(employee.getName().isEmpty() ? oldEmployee.getName() : employee.getName());
        oldEmployee.setGender(employee.getGender().isEmpty() ? oldEmployee.getGender() : employee.getGender());
        oldEmployee.setAge(employee.getAge() == null ? oldEmployee.getAge() : employee.getAge());

        return employeeRepo.save(oldEmployee);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return employeeRepo.findAllByGender(gender);
    }

    public Page<Employee> getCurrentPageEmployee(Integer pageNumber, Integer pageSize) {

        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return employeeRepo.findAll(pageable);
    }


}
