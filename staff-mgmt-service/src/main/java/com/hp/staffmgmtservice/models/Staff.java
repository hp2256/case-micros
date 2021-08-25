package com.hp.staffmgmtservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "staff")
public class Staff {
    @Id
    private String id;
    private int staffCode;
    private String empName;
    private Address empAddress;
    private long empSalary;
    private int empAge;
    private String empOccupation;
    private String empEmail;

    public Staff(String id, int staffCode, String empName, Address empAddress, long empSalary, int empAge, String empOccupation, String empEmail) {
        this.id = id;
        this.staffCode = staffCode;
        this.empName = empName;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
        this.empAge = empAge;
        this.empOccupation = empOccupation;
        this.empEmail = empEmail;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getStaffCode() {
        return staffCode;
    }

    public void setStaffCode(int staffCode) {
        this.staffCode = staffCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Address getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(Address empAddress) {
        this.empAddress = empAddress;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }

    public int getEmpAge() {
        return empAge;
    }

    public void setEmpAge(int empAge) {
        this.empAge = empAge;
    }

    public String getEmpOccupation() {
        return empOccupation;
    }

    public void setEmpOccupation(String empOccupation) {
        this.empOccupation = empOccupation;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }
}
