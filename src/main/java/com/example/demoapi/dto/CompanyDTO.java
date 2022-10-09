package com.example.demoapi.dto;

import com.example.demoapi.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {
    @NotNull
    private String companyName;
    @NotNull
    private Integer employeeNumber;
    @NotNull
    private List<Employee> employees;

}
