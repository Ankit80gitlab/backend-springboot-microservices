package com.cms.employeemanagement.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@Table(name = "EmpTable")
public class Employee {

    @Id
    @GeneratedValue
    @NotNull(message = "Must not be Empty and NULL")
    private int id;
    @NotBlank(message = "Employee first name can't be left empty")
    private String firstName;
    @NotBlank(message = "Employee last name can't be left empty")
    private String lastName;
    @NotBlank(message = "Employee department can't be left empty")
    private String department;
    @NotBlank(message = "Employee designation can't be left empty")
    private String designation;
    @Min(value=10000, message = "Minimum salary value  10000")
    @Max(value=50000, message = "Maximum salary value 50000")
    private double salary;
    @Email(message = "Please enter a valid email Id")
    @NotNull(message = "Email cannot be NULL")
    private String email;
    @NotBlank(message = "Employee username can't be left empty")
    @Pattern(regexp = "[A-Z 0-9]{7,12}", message = "Username must be a two capital digit followed by five digits.")
    private String username;
    @NotBlank(message = "Employee password can't be left empty")
    private String password;

    public Employee(){

    }
    public Employee(int id, String firstName, String lastName, String department, String designation, double salary, String email, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
