package com.hp.reservemgmtservice.dao;

import com.hp.reservemgmtservice.models.payments.Payments;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentDao extends MongoRepository<Payments,String> {
}
