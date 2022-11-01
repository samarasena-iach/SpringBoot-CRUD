package com.digiratina.codingassignment.controller;

import com.digiratina.codingassignment.exceptions.ResourceNotFoundException;
import com.digiratina.codingassignment.model.Employee;
import com.digiratina.codingassignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        return employeeService.getEmployee(employeeId);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        return employeeService.updateEmployee(employee, employeeId);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        employeeService.deleteEmployee(employeeId);
        return "Deleted Successfully";
    }
}
