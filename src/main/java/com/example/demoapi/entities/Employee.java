package com.example.demoapi.entities;

import com.example.demoapi.dto.Gender;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class  Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private String gender;

//    private Integer companyId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "companyId")
    private Company company;


    public Employee(Long id, String name, Integer age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
}
