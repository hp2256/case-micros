package com.hp.ownerservice.services;

import com.hp.ownerservice.models.Departments;
import com.hp.ownerservice.repos.DepartmentDetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentsRepo {
    @Autowired
    private DepartmentDetailsDao departmentDetailsDao;


    public List<Departments> getAll() {
        List<Departments> all = new ArrayList<>(departmentDetailsDao.findAll());
        return all;
    }

    public Departments getDepartment(String id) {
        if (departmentDetailsDao.findById(id).isPresent())
            return departmentDetailsDao.findById(id).get();
        else
            return null;
    }

    public Departments addDepartment(Departments departments) {
      return   departmentDetailsDao.save(departments);
    }

    public Departments updateDepartment(Departments departments) {
     return    departmentDetailsDao.save(departments);
    }

    public void deleteDepartment(String id) {
        departmentDetailsDao.deleteById(id);
    }
}
