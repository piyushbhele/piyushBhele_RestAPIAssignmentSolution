package com.greatlearning.employee.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.entity.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
    private EmployeeRepository emp_Repo;

    @Override
    public List<Employee> getAllEmployees(){
        return emp_Repo.findAll();
    }
    @Override
    public Employee findEmployeeByID(Integer id){
        Optional<Employee> employee = emp_Repo.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        return null;
    }

    @Override
    public List<Employee> findEmployeesByName(String firstName) {
        return emp_Repo.findByFirstName(firstName);
    }

    @Override
    public void AddEmployee(Employee employee) {
        emp_Repo.save(employee);
    }

    @Override
    public Employee UpdateEmployee(Employee updated_employee) {
        emp_Repo.save(updated_employee);
        return updated_employee;
    }

    @Override
    public void DeleteEmployee(Integer id) {
        emp_Repo.deleteById(id);
    }

    @Override
    public List<Employee> OrderByName(String order){
        if(order.equalsIgnoreCase("asc"))
            return emp_Repo.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
        else if(order.equalsIgnoreCase("desc"))
            return emp_Repo.findAll(Sort.by(Sort.Direction.DESC, "firstName"));
        else return null;
    }
}
