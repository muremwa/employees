package com.muremwa.employees.controllers;

import com.muremwa.employees.models.Employee;
import com.muremwa.employees.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService service;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> allEmployees() {
        return service.getEmployees();
    }

    @PostMapping
    public Employee newEmployee(@RequestBody Employee emp) {
        return service.createEmployee(emp);
    }

    @PutMapping("/{emp_id}")
    public Employee editEmployee(@PathVariable(value = "emp_id") Long id, @RequestBody Employee emp) {
        return service.updateEmployeeDetails(id, emp);
    }

    @DeleteMapping("/{emp_id}")
    public boolean removeEmployee(@PathVariable("emp_id") Long id) {
        return service.deleteEmployee(id);
    }

}
