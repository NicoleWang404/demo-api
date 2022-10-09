package com.example.demoapi.repository;

import com.example.demoapi.entities.Employee;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    List<Employee> findAll(Specification<Employee> employeeSpecification);

    List<Employee> findAllByCompanyId(Integer companyId);
}
