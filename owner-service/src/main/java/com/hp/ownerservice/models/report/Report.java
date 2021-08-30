package com.hp.ownerservice.models.report;

import java.util.Date;

//@Document(collection = "reports")
public class Report {
    private Date reportDate;
    private int numberOfStaff;
    private Long staffPayment;
    private Long totalIncome;

    Report(){}

    public Report(Date reportDate, int numberOfStaff, Long staffPayment, Long totalIncome) {
        this.reportDate = reportDate;
        this.numberOfStaff = numberOfStaff;
        this.staffPayment = staffPayment;
        this.totalIncome = totalIncome;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
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
