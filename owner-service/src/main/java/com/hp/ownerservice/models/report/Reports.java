package com.hp.ownerservice.models.report;

import java.util.List;

public class Reports {
    private List<Report> reports;

    public Reports(List<Report> reports) {
        this.reports = reports;
    }

    Reports(){}
    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }
}
