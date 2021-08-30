package com.hp.ownerservice.models.staff;

import java.util.List;

public class AllStaff {
    private List<Staff> staffs;

    AllStaff(){}
    public AllStaff(List<Staff> staffs) {
        this.staffs = staffs;
    }

    public List<Staff> getStaffs() {
        return staffs;
    }

    public void setStaffs(List<Staff> staffs) {
        this.staffs = staffs;
    }
}
