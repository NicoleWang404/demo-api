package com.example.demoapi.repository;

import com.example.demoapi.entities.Employee;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository

public class EmployeeRepository {
    int id =0;
    List<Employee> employeeList = new ArrayList<>();

    public EmployeeRepository() {
        employeeList.add(new Employee(1, "aaa", 22, "male"));
        employeeList.add(new Employee(2, "ccc", 23, "female"));
    }

    public List<Employee> getAllEmplpyee() {
        return employeeList;
    }

    public boolean createEmployee(Employee employee) {
        id++; //id作为主键是不可以被手动更改的
        employee.setId(id);
        employeeList.add(employee);
        return true;
    }
    public Employee getEmployeeById(Integer id) {
        return employeeList.stream().filter(i -> i.getId().equals(id)).findFirst().orElse(null);

    }
    public boolean deleteEmployee(Integer id) {
        employeeList.remove(getEmployeeById(id));
        return true;
    }
}
