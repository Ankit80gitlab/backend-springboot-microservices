package com.cms.employeeauthentication.employeeauthentication.service;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;
import com.cms.employeeauthentication.employeeauthentication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public Employee registerEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee login(String email, String password) {
        return null;
    }

    @Override
    public boolean removeEmployee(String email) {
        return false;
    }
}
