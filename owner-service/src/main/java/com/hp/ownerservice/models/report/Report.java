package com.hp.ownerservice.models.report;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private LocalDate reportDate;
    private int numberOfStaff;
    private Long staffPayment;
    private Long totalIncome;

    Report(){}

    public Report(LocalDate reportDate, int numberOfStaff, Long staffPayment, Long totalIncome) {
        this.reportDate = reportDate;
        this.numberOfStaff = numberOfStaff;
        this.staffPayment = staffPayment;
        this.totalIncome = totalIncome;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public int getNumberOfStaff() {
        return numberOfStaff;
    }

    public void setNumberOfStaff(int numberOfStaff) {
        this.numberOfStaff = numberOfStaff;
    }

    public Long getStaffPayment() {
        return staffPayment;
    }

    public void setStaffPayment(Long staffPayment) {
        this.staffPayment = staffPayment;
    }

    public Long getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(Long totalIncome) {
        this.totalIncome = totalIncome;
    }
}
