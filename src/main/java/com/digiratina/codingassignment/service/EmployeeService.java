package com.digiratina.codingassignment.service;

import com.digiratina.codingassignment.exceptions.ResourceNotFoundException;
import com.digiratina.codingassignment.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployee();

    Employee getEmployee(Long employeeId) throws ResourceNotFoundException;

    Employee updateEmployee(Employee employee, Long employeeId) throws ResourceNotFoundException;

    void deleteEmployee(Long employeeId) throws ResourceNotFoundException;

}
