package com.hp.reservemgmtservice.models;

import com.hp.reservemgmtservice.models.bills.Bill;

import java.util.List;

public class AllPayments {
    List<Payments> allPayments;

    AllPayments(){
    }

    public List<Payments> getAllBills() {
        return allPayments;
    }

    public void setAllBills(List<Payments> allPayments) {
        this.allPayments = allPayments;
    }

    public AllPayments(List<Payments> allPayments) {
        this.allPayments = allPayments;
    }
}
