package com.hp.reservemgmtservice.dao;

import com.hp.reservemgmtservice.models.bills.Bill;

import java.util.List;

public interface BillsDao {
    Bill saveBill(Bill bill);

    List<Bill> getAllBills();

    List<Bill> getAllBillPaginated(
            int pageNumber, int pageSize);

    Bill findOneById(String id);

    //   List<Bill> findByAgeRange(int lowerBound, int upperBound);

    void updateMultipleBill();

    Bill updateOneBill(Bill bill);

    void deleteBill(Bill bill);
}
