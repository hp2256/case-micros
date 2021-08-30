package com.hp.ownerservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departments")
public class Departments {
    @Id
    private String id;
    private int departmentName;
    private int numberOfStaff;

}
