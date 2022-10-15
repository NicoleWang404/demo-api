package com.example.demoapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "company")
public class Company {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String companyName;
    @Transient
    private Integer employeesNumber;
    private String  location;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Employee> employees =new ArrayList<>();

    @PostLoad @PostPersist
    void getEmployeeNumber() {
        this.employeesNumber = employees.size();
    }
}
