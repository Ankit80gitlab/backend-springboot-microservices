package com.cms.employeemanagement.service;

import com.cms.employeemanagement.model.Employee;
import com.cms.employeemanagement.model.EmployeeCredentialDTO;
import com.cms.employeemanagement.proxy.EmployeeCredProxy;
import com.cms.employeemanagement.repository.EmployeeRepositoryDAO;
import com.cms.employeemanagement.repository.EmployeeRepositoryEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    EmployeeRepositoryDAO employeeRepository;

    @Autowired
    EmployeeRepositoryEntityManager employeeRepositoryEntityManager;

    @Autowired
    private EmployeeCredProxy employeeCredProxy;

    public EmployeeService(EmployeeRepositoryDAO employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    //git

    public Employee registerEmployee(Employee employee) {
        employeeRepository.save(employee);
        EmployeeCredentialDTO employeeCredentialDTO = new EmployeeCredentialDTO();
        employeeCredentialDTO.setEmail(employee.getEmail());
        employeeCredentialDTO.setUsername(employee.getUsername());
        employeeCredentialDTO.setPassword(employee.getPassword());
        employeeCredProxy.sendEmpCredObjToAuthApp(employeeCredentialDTO);
        return null;
    }
    public Employee updateEmployee(int empId, Employee employee){
        if(employeeRepository.findById(empId).isPresent()){
            Employee emp = employeeRepository.findById(empId).get();
            emp.setDesignation(employee.getDesignation());
            emp.setDepartment(employee.getDepartment());
            employeeRepository.save(emp);
            System.out.println("Employee details updated");
            return emp;
        }
        System.out.println("Invalid employee id");
        return null;
    }

    public Employee searchEmployeeById(int empId){
        if(employeeRepository.findById(empId).isPresent()){
            System.out.println("Employee with emp id "+empId+" is present");
            Employee emp = new Employee();
            employeeRepository.findById(empId).get();
            return emp;
        }
        System.out.println("Employee with emp id "+empId+" is not present");
        return null;
    }

    public List<Employee> searchEmployeeByName(String name){
        List<Employee> allEmpList = employeeRepository.findAll();
        List<Employee> empWithSameName = new ArrayList<>();
        for(Employee e: allEmpList){
            if(e.getFirstName().equalsIgnoreCase(name)){
                empWithSameName.add(e);
            }
        }
        if(empWithSameName.isEmpty()){
            System.out.println("Unable to find employee with name : "+name);
            return null;
        }
        else{
            return empWithSameName;
        }
    }

    public List<Employee> searchEmployeeByDesignation(String designation){
        List<Employee> allEmpList = employeeRepository.findAll();
        List<Employee> empWithSameDesignation = new ArrayList<>();
        for(Employee e: allEmpList){
            if(e.getDesignation().equalsIgnoreCase(designation)){
                empWithSameDesignation.add(e);
            }
        }
        if(empWithSameDesignation.isEmpty()){
            System.out.println("Unable to find employee with designation : "+designation);
            return null;
        }
        else{
            return empWithSameDesignation;
        }
    }

    public List<Employee> searchEmployeeByDepartment(String department){
        List<Employee> allEmpList = employeeRepository.findAll();
        List<Employee> empWithSameDepartment = new ArrayList<>();
        for(Employee e: allEmpList){
            if(e.getDepartment().equalsIgnoreCase(department)){
                empWithSameDepartment.add(e);
            }
        }
        if(empWithSameDepartment.isEmpty()){
            System.out.println("Unable to find employee with department : "+department);
            return null;
        }
        else{
            return empWithSameDepartment;
        }
    }

    public List<Employee> searchByKeywordJpa(String keyword){
        List<Employee> newList = new ArrayList<>();
        newList = employeeRepository.findByDepartment(keyword);
        return newList;
    }

    public List<Employee> searchByKeywordEntMng(String keyword){
        return employeeRepositoryEntityManager.getAll(keyword);
    }


}
