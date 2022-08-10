package com.example.demoapi.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    private Integer id;
    private String companyName;
    private List<Employee> employeeList =new ArrayList<>();

    public Company(Integer id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }
}
