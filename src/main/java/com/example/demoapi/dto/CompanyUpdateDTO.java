package com.example.demoapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyUpdateDTO {
    @NotNull
    private String companyName;
    @NotNull
    private String location;

}
