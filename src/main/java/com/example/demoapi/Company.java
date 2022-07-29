package com.example.demoapi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private Integer id;
    private String companyName;
    private Integer employeesNumber;
    //private List <Employee> employeeList = new ArrayList<>();

}
