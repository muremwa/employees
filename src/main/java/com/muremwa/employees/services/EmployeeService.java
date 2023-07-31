package com.muremwa.employees.services;

import com.muremwa.employees.models.Employee;
import com.muremwa.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    @Autowired
    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public Employee createEmployee(Employee employee) {
        return repo.save(employee);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public boolean deleteEmployee(Long empId) {
        boolean empExists = repo.existsById(empId);

        if (empExists) {
            repo.deleteById(empId);
            return true;
        } else {
            return false;
        }
    }

    public Employee updateEmployeeDetails(Long id, Employee details) {
        Optional<Employee> oEmp = repo.findById(id);

        if (oEmp.isPresent()) {
            Employee emp = oEmp.get();
            emp.setFirstName(details.getFirstName());
            emp.setLastName(details.getLastName());
            emp.setDob(details.getDob());
            emp.setEmailId(details.getEmailId());
            return repo.save(emp);
        }

        return oEmp.get();
    }
}
