package com.cms.employeemanagement.proxy;

import com.cms.employeemanagement.model.EmployeeCredentialDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "employee-auth-service",url="localhost:8082")
public interface EmployeeCredProxy {

    @PostMapping("/app/auth/register")
    public ResponseEntity<?> sendEmpCredObjToAuthApp(@RequestBody EmployeeCredentialDTO employeeCredentialDTO);

}
