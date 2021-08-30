package com.hp.reservemgmtservice.dao;

import com.hp.reservemgmtservice.models.bills.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillsMongoDao extends MongoRepository<Bill,String> {
}
