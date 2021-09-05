package com.hp.ownerservice.services;

import com.hp.ownerservice.models.staff.AllStaff;
import com.hp.ownerservice.models.staff.Staff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StaffsService {
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(StaffsService.class);

    private String staffUrl ="http://case-staff/";
    String all = "allstaff";

    public long getStaff() {
        try {
            //owner-> staff service
            //staff -> localhost:8082/allstaff
            //rest template (url, String.class);
            AllStaff allStaff = restTemplate.getForObject(staffUrl+all, AllStaff.class);

            logger.info("staffs count {}", allStaff.getStaffs().stream().map(Staff::getEmpSalary).count());
            return allStaff.getStaffs().stream().map(Staff::getEmpSalary).count();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long getTotalPayment() {
        long incomeTotal=0;
        try {
            AllStaff allStaff = restTemplate.getForObject(staffUrl+all, AllStaff.class);
            logger.info("staffs {}", allStaff.getStaffs().stream().map(Staff::getEmpSalary).reduce(0L, Long::sum));
          incomeTotal= allStaff.getStaffs().stream().map(Staff::getEmpSalary).reduce(0L, Long::sum);
       return incomeTotal;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return incomeTotal;
    }
}
