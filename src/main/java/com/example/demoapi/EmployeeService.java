package com.example.demoapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employeeMap = new HashMap<>();
    public EmployeeService() {
        employeeMap.put(1, new Employee(1, "AAA", 22, "male"));
        employeeMap.put(2, new Employee(2, "BBB", 33,"female"));

    }

    public List<Employee> getAllEmployee() {
        return new ArrayList<>(employeeMap.values());
    }

    public void createEmployee( Employee employee) {
        employeeMap.put(employee.getId(), employee);
    }

    public Employee getEmployee (Integer id) {
        return employeeMap.get(id);
    }

}
