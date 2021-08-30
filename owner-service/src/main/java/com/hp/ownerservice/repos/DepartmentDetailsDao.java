package com.hp.ownerservice.repos;

import com.hp.ownerservice.models.Departments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentDetailsDao extends MongoRepository<Departments, String> {
    Long deleteDepartmentById(String id);
}
