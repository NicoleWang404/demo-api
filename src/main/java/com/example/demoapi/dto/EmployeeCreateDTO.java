package com.example.demoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class EmployeeCreateDTO {
    @NotNull
    private Integer companyId;
    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private String gender;
}
