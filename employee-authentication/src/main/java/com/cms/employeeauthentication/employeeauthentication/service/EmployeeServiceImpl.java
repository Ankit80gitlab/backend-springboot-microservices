package com.cms.employeeauthentication.employeeauthentication.service;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;
import com.cms.employeeauthentication.employeeauthentication.model.EmployeeCO;
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
    public Employee login(EmployeeCO employeeCo) {
        Employee emp = new Employee();
        emp.setEmail(employeeCo.getEmail());
        emp.setPassword(employeeCo.getPassword());

        if(employeeRepository.findById(emp.getEmail()).isPresent()){
            Employee emp1 = employeeRepository.findById(emp.getEmail()).get();
            if(emp1.getPassword().equals(emp.getPassword())){
                emp1.setPassword("");
                return emp;

            }
            else{
                return null;
            }
        }
        else{
            return null;
        }
    }

    @Override
    public boolean removeEmployee(String email) {
        return false;
    }
}
