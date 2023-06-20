package com.web.employeeportal.services.impl;

import com.web.employeeportal.entity.EmployeeEntity;
import com.web.employeeportal.model.Employee;
import com.web.employeeportal.repository.EmployeeRepository;
import com.web.employeeportal.services.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
