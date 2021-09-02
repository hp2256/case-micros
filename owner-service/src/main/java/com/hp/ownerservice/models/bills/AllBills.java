package com.hp.ownerservice.models.bills;

import java.util.List;

public class AllBills {
    List<Bill> allBills;

    AllBills(){
    }

    public List<Bill> getAllBills() {
        return allBills;
    }

    public void setAllBills(List<Bill> allBills) {
        this.allBills = allBills;
    }

    public AllBills(List<Bill> allBills) {
        this.allBills = allBills;
    }
}
