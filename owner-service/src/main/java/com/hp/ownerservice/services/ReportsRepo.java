package com.hp.ownerservice.services;

import com.hp.ownerservice.models.report.Report;
import com.hp.ownerservice.repos.ReportsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportsRepo {
    @Autowired
    private ReportsDao reportsDao;


    public List<Report> getAll() {
        List<Report> all = new ArrayList<>(reportsDao.findAll());
        return all;
    }

    public Report getReport(String id) {
        if (reportsDao.findById(id).isPresent())
            return reportsDao.findById(id).get();
        else
            return null;
    }

    public Report addReport(Report report) {
        return reportsDao.save(report);
    }

    public Report updateReport(Report report) {
      return   reportsDao.save(report);
    }

    public void deleteReport(Report report){
         reportsDao.delete(report);
    }
    /*public void deleteReport(String id) {
        reportsDao.deleteById(id);
    }*/
}
