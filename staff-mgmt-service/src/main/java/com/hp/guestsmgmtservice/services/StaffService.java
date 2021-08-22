package com.hp.guestsmgmtservice.services;

import com.hp.guestsmgmtservice.models.Staff;
import com.hp.guestsmgmtservice.repos.StaffRepository;
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

    public Staff getGuest(int id) {
        if (staffRepository.findById(id).isPresent())
            return staffRepository.findById(id).get();
        else
            return null;
    }

    public void addGuest(Staff staff) {
        staffRepository.save(staff);
    }

    public void updateGuest(Staff staff) {
        staffRepository.save(staff);
    }

    public void deleteGuest(Staff staff) {
        staffRepository.delete(staff);
    }
}
