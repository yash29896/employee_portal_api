package com.web.employeeportal.controller;

import com.web.employeeportal.model.Employee;
import com.web.employeeportal.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee){
        return service.createEmployee(employee);
    }
}
