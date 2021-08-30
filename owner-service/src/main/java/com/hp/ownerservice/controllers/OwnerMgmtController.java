package com.hp.ownerservice.controllers;

import com.hp.ownerservice.models.Departments;
import com.hp.ownerservice.models.report.Report;
import com.hp.ownerservice.models.report.Reports;
import com.hp.ownerservice.services.DepartmentsRepo;
import com.hp.ownerservice.services.StaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OwnerMgmtController {

    @Autowired
    DepartmentsRepo departmentsRepo;
    @Autowired
    StaffsService staffsService;

    @GetMapping("/alldepartment")
    public List<Departments> getAllDepartment() {
        return departmentsRepo.getAll();
    }

    /* @GetMapping("/all")
     public Guests getAll(){
         return guestsService.getAllGuests();
     }*/
    @GetMapping("/department/{id}")
    public Departments getDpt(@PathVariable String id) {
        return departmentsRepo.getDepartment(id);
    }

    @PostMapping("/adddepartment")
    public void addDpt(@RequestBody Departments newDepartment) {
        departmentsRepo.addDepartment(newDepartment);
    }

    @PutMapping(value = "/updatedepartment")
    public void updateDpt(@RequestBody Departments department) {
        departmentsRepo.updateDepartment(department);
    }

    @DeleteMapping("/deletedepartment/{id}")
    public void removeDpt(@PathVariable String id) {
        departmentsRepo.deleteDepartment(id);
    }

    @GetMapping(value = "/viewreport")
    public Report generateReport() {
        long staffPay = staffsService.getTotalPayment();
        long totalStaff = staffsService.getStaff();
        Date date = new Date();
        return new Report(date, Math.toIntExact(totalStaff),staffPay,0L);
    }
}
