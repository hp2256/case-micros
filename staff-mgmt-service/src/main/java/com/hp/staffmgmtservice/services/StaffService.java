package com.hp.staffmgmtservice.services;

import com.hp.staffmgmtservice.models.Staff;
import com.hp.staffmgmtservice.repos.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {
    @Autowired
    private StaffRepository staffRepository;


    public List<Staff> getAll() {
        List<Staff> all = new ArrayList<>(staffRepository.findAll());
        return all;
    }

    public Staff getStaff(String id) {
        if (staffRepository.findById(id).isPresent())
            return staffRepository.findById(id).get();
        else
            return null;
    }

    public void addStaff(Staff staff) {
        staffRepository.insert(staff);
    }

    public void updateStaff(Staff staff) {
        staffRepository.save(staff);
    }

 /*   public void deleteStaff(String id) {
        staffRepository.deleteById(Integer.parseInt(id));
    }*/
    public void deleteStaffById(String id){
        staffRepository.deleteStaffById(id);
    }
}
