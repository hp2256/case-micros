package com.hp.ownerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public class AllDepartments {

    List<Departments> allDepartments;

    public AllDepartments() {
    }

    public AllDepartments(List<Departments> allDepartments) {
        this.allDepartments = allDepartments;
    }

    public List<Departments> getAllDepartments() {
        return allDepartments;
    }

    public void setAllDepartments(List<Departments> allDepartments) {
        this.allDepartments = allDepartments;
    }
}
