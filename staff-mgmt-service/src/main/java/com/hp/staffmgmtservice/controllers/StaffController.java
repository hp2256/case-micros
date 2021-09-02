package com.hp.staffmgmtservice.controllers;

import com.hp.staffmgmtservice.models.AllStaff;
import com.hp.staffmgmtservice.models.Staff;
import com.hp.staffmgmtservice.services.StaffService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "*",allowedHeaders ="*")
public class StaffController {

    @Autowired
    StaffService staffService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/allstaff")
    @ApiOperation(value = "All the staff", notes = "Fetches all the staff in the hotel")
    public AllStaff getAllStaff(){
        AllStaff allStaff = new AllStaff();
        allStaff.setStaffs(staffService.getAll());
        return allStaff;
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    @GetMapping("/staff/{id}")
    @ApiOperation(value = "Single staff detail", notes = "Fetches the staff given that is in the hotel")
    public Staff getStaff(@PathVariable String id){
        return staffService.getStaff(id);
    }

    @PostMapping("/addstaff")
    @ApiOperation(value = "add single staff", notes = "adds the staff in the hotel")
    public void addStaff(@RequestBody Staff newStaff){
        staffService.addStaff(newStaff);
    }

    @PutMapping(value = "/updatestaff")
    @ApiOperation(value = "update single staff", notes = "updates the staff passed in the hotel system")
    public void updateEmp(@RequestBody Staff staff) {
        staffService.updateStaff(staff);
    }

    @DeleteMapping("/deletestaff/{id}")
    @ApiOperation(value = "deletes single staff", notes = "deletes the staff passed from the hotel system")
    public void removeEmp(@PathVariable String id){
        staffService.deleteStaffById(id);
    }

}
