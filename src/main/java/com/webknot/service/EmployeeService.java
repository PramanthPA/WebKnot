package com.webknot.service;

import com.webknot.dto.EmployeeDTO;
import com.webknot.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee createEmployee(EmployeeDTO employeeDTO);
    Employee updateEmployee(Long id, EmployeeDTO employeeDTO);
    boolean deleteEmployee(Long id);
}
