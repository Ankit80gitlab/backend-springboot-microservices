package com.cms.employeeauthentication.employeeauthentication.security;

import com.cms.employeeauthentication.employeeauthentication.model.Employee;

import java.util.Map;

public interface SecurityTokenGenerator {

    public Map<String,String> generateToken(Employee employee);
}
