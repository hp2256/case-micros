package com.hp.ownerservice.models.staff;

import org.springframework.data.annotation.Id;

public class Staff {
    @Id
    private String id;

    private long empSalary;


    public Staff(){}

    public Staff(String id, long empSalary) {
        this.id = id;
        this.empSalary = empSalary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(long empSalary) {
        this.empSalary = empSalary;
    }
}
