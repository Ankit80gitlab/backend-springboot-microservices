package com.cms.employeeauthentication.employeeauthentication.controller;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;
import com.cms.employeeauthentication.employeeauthentication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/app/auth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }
}
