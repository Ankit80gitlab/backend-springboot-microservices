package com.cms.employeeauthentication.employeeauthentication.controller;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;
import com.cms.employeeauthentication.employeeauthentication.model.EmployeeCO;
import com.cms.employeeauthentication.employeeauthentication.security.SecurityTokenGenerator;
import com.cms.employeeauthentication.employeeauthentication.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/app/auth")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SecurityTokenGenerator securityTokenGenerator;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.registerEmployee(employee), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody EmployeeCO employeeCo) {
        Employee result = employeeService.login(employeeCo);
        if (result != null) {
            Map<String, String> key = securityTokenGenerator.generateToken(result);
            return new ResponseEntity<>(key,HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Authentication failed", HttpStatus.NOT_FOUND);
        }
    }


}
