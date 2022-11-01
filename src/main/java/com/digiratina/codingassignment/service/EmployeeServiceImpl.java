package com.digiratina.codingassignment.service;

import com.digiratina.codingassignment.exceptions.ResourceNotFoundException;
import com.digiratina.codingassignment.model.Employee;
import com.digiratina.codingassignment.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(Long employeeId) throws ResourceNotFoundException {
        return employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("[READ] EMPLOYEE NOT FOUND FOR ID:" + employeeId));
    }

    @Override
    public Employee updateEmployee(Employee employee, Long employeeId) throws ResourceNotFoundException {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("[UPDATE] EMPLOYEE NOT FOUND FOR ID:" + employeeId));

        if (Objects.nonNull(employee.getEmployeeName()) && !"".equalsIgnoreCase(employee.getEmployeeName())) {
            existingEmployee.setEmployeeName(employee.getEmployeeName());
        }

        if (Objects.nonNull(employee.getAddress()) && !"".equalsIgnoreCase(employee.getAddress())) {
            existingEmployee.setAddress(employee.getAddress());
        }

        if (Objects.nonNull(employee.getContactNo()) && !"".equalsIgnoreCase(employee.getContactNo())) {
            existingEmployee.setContactNo(employee.getContactNo());
        }

        return employeeRepository.save(existingEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
        Employee existingEmployee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("[DELETE] EMPLOYEE NOT FOUND FOR ID:" + employeeId));
        employeeRepository.deleteById(employeeId);
    }
}
