package com.cms.employeemanagement.repository;


import com.cms.employeemanagement.model.Employee;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepositoryEntityManager {

    @Autowired
    private EntityManager entityManager;

    public List<Employee> getAll(String keyword){
        System.out.println("entered api keyword "+keyword);
        String q = "select (e.firstName, e.lastName) from Employee e where concat(e.department, e.designation) LIKE : key";
        TypedQuery<Employee> query = entityManager.createQuery(q,Employee.class);
        return query.setParameter("key",'%'+keyword+'%').getResultList();
    }
}
