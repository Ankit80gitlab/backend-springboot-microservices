package com.cms.employeeauthentication.employeeauthentication.service;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;
import com.cms.employeeauthentication.employeeauthentication.model.EmployeeCO;

public interface EmployeeService {

    public Employee registerEmployee(Employee employee);
    public Employee login(EmployeeCO employeeCo);
    public boolean removeEmployee(String email);


}
