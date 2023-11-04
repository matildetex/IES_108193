package pt.deti.ies.datarestint.service;

import java.util.List;

import pt.deti.ies.datarestint.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(Employee Employee);

    Employee getEmployeeById(Long EmployeeId);

    List<Employee> getAllEmployees();

    Employee updateEmployee(Employee Employee);

    void deleteEmployee(Long EmployeeId);

    // Employee findByEmailId(String employeeEmail);
}