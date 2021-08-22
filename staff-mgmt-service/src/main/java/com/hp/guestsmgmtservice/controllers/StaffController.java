package com.hp.guestsmgmtservice.controllers;

import com.hp.guestsmgmtservice.models.Staff;
import com.hp.guestsmgmtservice.services.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GuestController {

    @Autowired
    StaffService staffService;

    @GetMapping("/allguests")
    public List<Staff> getAllGuests(){
        return staffService.getAll();
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/

    @PostMapping("/addguest")
    public void addGuest(@RequestBody Staff newStaff){
        staffService.addGuest(newStaff);
    }
}
