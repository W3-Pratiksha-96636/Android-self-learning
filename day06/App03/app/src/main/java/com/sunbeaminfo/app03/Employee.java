package com.sunbeaminfo.app03;

import java.io.Serializable;
import java.util.Objects;

public class Employee implements Serializable {

    private int empid;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int empid, String name, double salary) {
        this.empid = empid;
        this.name = name;
        this.salary = salary;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return empid == employee.empid;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(empid);
    }
}



