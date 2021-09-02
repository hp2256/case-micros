package com.hp.ownerservice.controllers;

import com.hp.ownerservice.models.AllDepartments;
import com.hp.ownerservice.models.Departments;
import com.hp.ownerservice.models.report.Report;
import com.hp.ownerservice.models.report.Reports;
import com.hp.ownerservice.services.DepartmentsRepo;
import com.hp.ownerservice.services.IncomeService;
import com.hp.ownerservice.services.ReportsRepo;
import com.hp.ownerservice.services.StaffsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OwnerMgmtController {

    @Autowired
    DepartmentsRepo departmentsRepo;
    @Autowired
    StaffsService staffsService;

    @Autowired
    ReportsRepo reportsRepo;

    @Autowired
    IncomeService incomeService;

    @GetMapping("/alldepartment")
    public AllDepartments getAllDepartment() {
        return new AllDepartments(departmentsRepo.getAll());
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
    public Departments addDpt(@RequestBody Departments newDepartment) {
     return    departmentsRepo.addDepartment(newDepartment);
    }

    @PutMapping(value = "/updatedepartment")
    public void updateDpt(@RequestBody Departments department) {
        departmentsRepo.updateDepartment(department);
    }

    @DeleteMapping("/deletedepartment/{id}")
    public void removeDpt(@PathVariable String id) {
        departmentsRepo.deleteDepartment(id);
    }

    @RequestMapping(value = "/viewreport")
    public Report generateReport() {
        long staffPay = staffsService.getTotalPayment();
        long totalStaff = staffsService.getStaff();
        LocalDate date = LocalDate.now();
        double income = incomeService.getIncome();
        return reportsRepo.addReport(new Report(date, Math.toIntExact(totalStaff), staffPay, (long) income));
    }

    @GetMapping(value = "/allreports")
    public Reports allReports() {
        return new Reports(reportsRepo.getAll());
    }
    @RequestMapping(value = "/deletereport")
    public void deleteReport(@RequestBody Report report){
        reportsRepo.deleteReport(report);
    }

}
