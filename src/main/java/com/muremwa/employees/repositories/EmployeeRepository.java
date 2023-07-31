package com.muremwa.employees.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.muremwa.employees.models.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {}
