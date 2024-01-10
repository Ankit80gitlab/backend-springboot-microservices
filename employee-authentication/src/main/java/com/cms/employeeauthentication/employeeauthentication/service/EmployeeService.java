package com.cms.employeeauthentication.employeeauthentication.service;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;

public interface EmployeeService {

    public Employee registerEmployee(Employee employee);
    public Employee login(String email, String password);
    public boolean removeEmployee(String email);


}
