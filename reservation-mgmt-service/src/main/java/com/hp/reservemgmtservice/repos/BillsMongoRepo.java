package com.hp.reservemgmtservice.repos;

import com.hp.reservemgmtservice.dao.BillsMongoDao;
import com.hp.reservemgmtservice.models.bills.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BillsMongoRepo {

    @Autowired
    private BillsMongoDao billsMongoDao;

    public List<Bill> getAllBills() {
        return billsMongoDao.findAll();
    }

    public Bill addBill(Bill bill) {
        return billsMongoDao.save(bill);
    }

}
