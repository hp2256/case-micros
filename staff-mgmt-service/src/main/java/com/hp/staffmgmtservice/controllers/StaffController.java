package com.hp.staffmgmtservice.controllers;

import com.hp.staffmgmtservice.models.Staff;
import com.hp.staffmgmtservice.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",allowedHeaders ="*")
public class StaffController {

    @Autowired
    StaffService staffService;

    @GetMapping("/allstaff")
    public List<Staff> getAllStaff(){
        return staffService.getAll();
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    @GetMapping("/staff/{id}")
    public Staff getStaff(@PathVariable String id){
        return staffService.getStaff(id);
    }
    @PostMapping("/addstaff")
    public void addStaff(@RequestBody Staff newStaff){
        staffService.addStaff(newStaff);
    }

    @PutMapping(value = "/updatestaff")
    public void updateEmp(@RequestBody Staff staff) {
        staffService.updateStaff(staff);
    }
    @DeleteMapping("/deletestaff/{id}")
    public void removeEmp(@PathVariable String id){
        staffService.deleteStaffById(id);
    }

}
