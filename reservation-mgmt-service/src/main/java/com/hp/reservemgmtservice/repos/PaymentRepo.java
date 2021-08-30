package com.hp.reservemgmtservice.repos;

import com.hp.reservemgmtservice.dao.PaymentDao;
import com.hp.reservemgmtservice.models.Payments;
import com.hp.reservemgmtservice.models.bills.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepo {
    @Autowired
    PaymentDao paymentDao;

    @Autowired
    BillsRepo billsRepo;

    public List<Payments> getAll() {
        return new ArrayList<>(paymentDao.findAll());
    }

    public Payments getPayments(String id) {
        if (paymentDao.findById(id).isPresent())
            return paymentDao.findById(id).get();
        else
            return null;
    }

    public Payments addPayments(Payments payments) {
        Bill updateBillStatus = billsRepo.findOneById(payments.getBillId());
        updateBillStatus.setPaidStatus(true);
        return paymentDao.save(payments);
    }

    public Payments updatePayments(Payments payments) {
        return paymentDao.save(payments);
    }

    public void deletePayment(Payments payments) {
        paymentDao.delete(payments);
    }
}
