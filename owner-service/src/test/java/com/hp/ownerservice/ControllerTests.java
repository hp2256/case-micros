package com.hp.ownerservice;

import com.hp.ownerservice.models.Departments;
import com.hp.ownerservice.repos.DepartmentDetailsDao;
import com.hp.ownerservice.services.DepartmentsRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ControllerTests {
    @InjectMocks
    private DepartmentsRepo departmentsRepo;

    @Mock
    private DepartmentDetailsDao departmentDetailsDao;

    @Test
    void testAdd() {
        Departments department = new Departments("cooks", 30);
        when(departmentsRepo.addDepartment(department)).thenReturn(department);
        assertEquals(department, departmentsRepo.addDepartment(department));
    }

    @Test
    void testAll() {
        Departments department = new Departments("cooks", 30);
        Departments department2 = new Departments("cooks", 30);
        List<Departments> allDepartments = new ArrayList<>(Arrays.asList(department, department2));

        when(departmentsRepo.getAll()).thenReturn(allDepartments);
        assertEquals(allDepartments.size(), departmentsRepo.getAll().size());
    }

    @Test
    void testFindOne() {
        Departments department = new Departments("cooks", 30);
        when(departmentsRepo.getDepartmentById("1")).thenReturn(department);
        assertEquals(department, departmentsRepo.getDepartmentById("1"));
    }

    @Test
    void testUpdateOne() {
        Departments department = new Departments("cooks", 30);
        when(departmentsRepo.updateDepartment(department)).thenReturn(department);
        assertEquals(department,departmentsRepo.updateDepartment(department));
    }


}
