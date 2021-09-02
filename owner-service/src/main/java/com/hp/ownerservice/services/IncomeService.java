package com.hp.ownerservice.services;

import com.hp.ownerservice.models.bills.AllBills;
import com.hp.ownerservice.models.bills.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class IncomeService {
    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(IncomeService.class);
    private String url ="http://case-reservation/";

    public double getIncome(){
        double income = 0;
        try {
            AllBills allBills = restTemplate.getForObject(url + "getbills", AllBills.class);
            for (Bill bill : allBills.getAllBills()) {
                income=income+ bill.getPrice()+bill.getTaxes();
            }
        }
        catch (Exception e){
            logger.error("Error "+e);
        }
        return income;
    }

}
