package com.cms.employeemanagement.repository;

import com.cms.employeemanagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepositoryDAO extends JpaRepository<Employee,Integer> {


    @Query(value = "SELECT * FROM emp_table WHERE concat(department, ' ', designation, ' ', first_name) LIKE %:keyword%", nativeQuery = true)
    public List<Employee> findByDepartment(@Param("keyword") String keyword);
}
