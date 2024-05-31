package com.webknot.service;

import com.webknot.dto.EmployeeDTO;
import com.webknot.entity.Employee;
import com.webknot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setEmail(employeeDTO.getEmail());
        employee.setTechStack(employeeDTO.getTechStack());
        employee.setYearsOfExperience(employeeDTO.getYearsOfExperience());
        employee.setYearsInWebknot(employeeDTO.getYearsInWebknot());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Long id, EmployeeDTO employeeDTO) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        if (employee != null) {
            employee.setName(employeeDTO.getName());
            employee.setEmail(employeeDTO.getEmail());
            employee.setTechStack(employeeDTO.getTechStack());
            employee.setYearsOfExperience(employeeDTO.getYearsOfExperience());
            employee.setYearsInWebknot(employeeDTO.getYearsInWebknot());
            return employeeRepository.save(employee);
        }
        return null;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
