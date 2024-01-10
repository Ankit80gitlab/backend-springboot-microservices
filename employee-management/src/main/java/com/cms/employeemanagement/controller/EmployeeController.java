package com.cms.employeemanagement.controller;

import com.cms.employeemanagement.model.Employee;
import com.cms.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("/app/emp")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getAllEmployees(){
        return new ResponseEntity<>(employeeService.getAllEmployees(),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.registerEmployee(employee),HttpStatus.OK);
    }

    @PostMapping("/update/{empId}")
    public ResponseEntity<?> updateEmployee(@PathVariable int empId, @RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.updateEmployee(empId,employee),HttpStatus.OK);
    }

    @PostMapping("/findbyid/{empId}")
    public ResponseEntity<?> searchEmployeeByIdEmployee(@PathVariable int empId){
        return new ResponseEntity<>(employeeService.searchEmployeeById(empId),HttpStatus.OK);
    }

    @PostMapping("/findbyname/{name}")
    public ResponseEntity<?> searchEmployeeByName(@PathVariable String name){
        return new ResponseEntity<>(employeeService.searchEmployeeByName(name),HttpStatus.OK);
    }

    @PostMapping("/findbydesignation/{designation}")
    public ResponseEntity<?> searchEmployeeByDesignation(@PathVariable String designation){
        return new ResponseEntity<>(employeeService.searchEmployeeByDesignation(designation),HttpStatus.OK);
    }

    @PostMapping("/findbydepartment/{department}")
    public ResponseEntity<?> searchEmployeeByDepartment(@PathVariable String department){
        return new ResponseEntity<>(employeeService.searchEmployeeByDepartment(department),HttpStatus.OK);
    }
    
    @PostMapping("/jpa/{keyword}")
    public ResponseEntity<?> fromJpaRepo(@PathVariable String keyword){
        return new ResponseEntity<>(employeeService.searchByKeywordJpa(keyword),HttpStatus.OK);
    }

    @PostMapping("/entMng/{keyword}")
    public ResponseEntity<?> fromEntMng(@PathVariable String keyword){
        return new ResponseEntity<>(employeeService.searchByKeywordEntMng(keyword),HttpStatus.OK);
    }

}
