package com.greatlearning.employee.service;

import java.util.List;

import com.greatlearning.employee.entity.Employee;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void AddEmployee(Employee employee);

    public Employee UpdateEmployee(Employee updated_employee);

    public Employee findEmployeeByID(Integer id);

    public List<Employee> findEmployeesByName(String firstName);

    public List<Employee> OrderByName(String order);

    public void DeleteEmployee(Integer id);
}
