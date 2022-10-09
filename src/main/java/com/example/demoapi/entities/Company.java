package com.example.demoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "company")
public class Company {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String companyName;
    private Integer employeesNumber;


    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Employee> employees = new ArrayList<>();
    public Company(Integer id, String companyName) {
    }

    public List<Employee> getEmployeeList() {
        return null;
    }
}
