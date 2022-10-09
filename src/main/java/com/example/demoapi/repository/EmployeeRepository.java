package com.example.demoapi.repository;

import com.example.demoapi.dto.Gender;
import com.example.demoapi.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class EmployeeRepository {
    Long id =0L;
    List<Employee> employeeList = new ArrayList<>();

//    public EmployeeRepository() {
//        employeeList.add(new Employee(1L, "aaa", 22, Gender.MALE));
//        employeeList.add(new Employee(2L, "ccc", 23, Gender.FEMALE));
//        employeeList.add(new Employee(3L, "qqq", 22, Gender.MALE));
//        employeeList.add(new Employee(4L, "z", 23, Gender.FEMALE));
//        employeeList.add(new Employee(5L, "a", 22, Gender.MALE));
//        employeeList.add(new Employee(6L, "g", 23, Gender.FEMALE));
//    }

    public List<Employee> getAllEmployee() {
        return employeeList;
    }

    public boolean createEmployee(Employee employee) {
        id++; //id作为主键是不可以被手动更改的
        employee.setId(id);
        employeeList.add(employee);
        return true;
    }
    public Employee getEmployeeById(Integer id) {
//        final var companyStream = companyList.stream().filter(i -> i.getId().equals(id));
//        return companyStream.findFirst().orElse(null);
        return employeeList.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);

    }
    public boolean deleteEmployee(Integer id) {
        employeeList.remove(getEmployeeById(id));
        return true;
    }
    public Employee getEmployeeByGender(String gender) {
        return employeeList.stream().filter(i -> i.getGender().equals(gender)).findFirst().orElse(null);

    }
}
