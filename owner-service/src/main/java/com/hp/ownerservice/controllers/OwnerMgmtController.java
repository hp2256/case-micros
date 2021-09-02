package com.hp.ownerservice.controllers;

import com.hp.ownerservice.models.AllDepartments;
import com.hp.ownerservice.models.Departments;
import com.hp.ownerservice.models.report.Report;
import com.hp.ownerservice.models.report.Reports;
import com.hp.ownerservice.services.DepartmentsRepo;
import com.hp.ownerservice.services.IncomeService;
import com.hp.ownerservice.services.ReportsRepo;
import com.hp.ownerservice.services.StaffsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
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
    @ApiOperation(value = "All deparments", notes = "Fetches all the departments in the hotel")
    public AllDepartments getAllDepartment() {
        return new AllDepartments(departmentsRepo.getAll());
    }

    /* @GetMapping("/all")
     public Guests getAll(){
         return guestsService.getAllGuests();
     }*/

    @GetMapping("/department/{id}")
    @ApiOperation(value = "single deparment", notes = "Fetches given department in the hotel")
    public Departments getDpt(@PathVariable String id) {
        return departmentsRepo.getDepartment(id);
    }

    @PostMapping("/adddepartment")
    @ApiOperation(value = "Add deparments", notes = "Adds the given department in the hotel")
    public Departments addDpt(@RequestBody Departments newDepartment) {
        return departmentsRepo.addDepartment(newDepartment);
    }

    @PutMapping(value = "/updatedepartment")
    @ApiOperation(value = "Update deparments", notes = "Updates the given department in the hotel")
    public void updateDpt(@RequestBody Departments department) {
        departmentsRepo.updateDepartment(department);
    }

    @DeleteMapping("/deletedepartment/{id}")
    @ApiOperation(value = "Delete deparments", notes = "Deletes the given department in the hotel")
    public void removeDpt(@PathVariable String id) {
        departmentsRepo.deleteDepartment(id);
    }

    @RequestMapping(value = "/viewreport")
    @ApiOperation(value = "Generate Daily Report", notes = "Creates a report of current date")
    public Report generateReport() {
        long staffPay = staffsService.getTotalPayment();
        long totalStaff = staffsService.getStaff();
        LocalDate date = LocalDate.now();
        double income = incomeService.getIncome();
        return reportsRepo.addReport(new Report(date, Math.toIntExact(totalStaff), staffPay, (long) income));
    }

    @GetMapping(value = "/allreports")
    @ApiOperation(value = "View All Report", notes = "View all the reports in the system")
    public Reports allReports() {
        return new Reports(reportsRepo.getAll());
    }

    @RequestMapping(value = "/deletereport")
    @ApiOperation(value = "Delete Report", notes = "deletes a report of current date")
    public void deleteReport(@RequestBody Report report) {
        reportsRepo.deleteReport(report);
    }

}
