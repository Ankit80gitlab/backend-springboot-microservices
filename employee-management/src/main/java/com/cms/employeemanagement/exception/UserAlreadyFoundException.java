package com.cms.employeemanagement.exception;

public class UserAlreadyFoundException extends Exception{

    public UserAlreadyFoundException(String error){
        super(error);
    }
}
