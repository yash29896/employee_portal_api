package com.web.employeeportal.services.impl;

import com.web.employeeportal.entity.EmployeeEntity;
import com.web.employeeportal.model.Employee;
import com.web.employeeportal.repository.EmployeeRepository;
import com.web.employeeportal.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;
    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity entity = new EmployeeEntity();;
        BeanUtils.copyProperties(employee, entity);
        repository.save(entity);
        return employee;
    }

    public List<Employee> getAllEmployees() {
            List<EmployeeEntity> employeeEntities
                    = repository.findAll();

        List<Employee> employees = new ArrayList<>();
        for (EmployeeEntity emp : employeeEntities) {
            Employee employee = new Employee(
                    emp.getFirstName(),
                    emp.getLastName(),
                    emp.getEmailId());
            employees.add(employee);
        }
        return employees;
    }

}
