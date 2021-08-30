package com.hp.reservemgmtservice.repos;

import com.hp.reservemgmtservice.dao.BillsDao;
import com.hp.reservemgmtservice.models.bills.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class BillsRepo implements BillsDao {
    private final MongoTemplate mongoTemplate;
    Logger logger = LoggerFactory.getLogger(BillsRepo.class);

    @Autowired
    public BillsRepo(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Bill saveBill(Bill bill) {
        //logger.info("SAVE BILL {}",mongoTemplate);
       mongoTemplate.save(bill);
       return bill;

    }

    @Override
    public List<Bill> getAllBills() {
        return mongoTemplate.findAll(Bill.class);
    }

    @Override
    public List<Bill> getAllBillPaginated(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Bill findOneById(String id) {
        return mongoTemplate.findById(id, Bill.class);

    }

    @Override
    public void updateMultipleBill() {

    }

    @Override
    public Bill updateOneBill(Bill bill) {
        mongoTemplate.save(bill);
        return bill;
    }

    @Override
    public void deleteBill(Bill bill) {
        mongoTemplate.remove(bill);
    }
}
