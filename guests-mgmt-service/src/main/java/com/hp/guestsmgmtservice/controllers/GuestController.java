package com.hp.guestsmgmtservice.controllers;

import com.hp.guestsmgmtservice.models.AllGuests;
import com.hp.guestsmgmtservice.models.Guest;
import com.hp.guestsmgmtservice.services.GuestsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class GuestController {

    @Autowired
    GuestsService guestsService;

    @GetMapping("/allguests")
    @ApiOperation(value = "All the guests", notes = "Fetches all the guests registered in the hotel")
    public AllGuests getAllGuests() {
        return new AllGuests(guestsService.getAll());
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
   @GetMapping("/guest/{id}")
   @ApiOperation(value = "Single guest detail", notes = "Fetches the registered guest given that is in the hotel")
   public Guest getGuest(@PathVariable String id){
       return guestsService.getGuest(id);
   }

    @PostMapping("/addguest")
    @ApiOperation(value = "add single guest", notes = "adds the guest in the hotel system")
    public Guest addGuest(@RequestBody Guest newGuest) {
        return guestsService.addGuest(newGuest);
    }

    @PutMapping("/updateguest")
    @ApiOperation(value = "update single guest", notes = "updates the guest passed in the hotel system")
    public Guest updateGuest(@RequestBody Guest updateGuest) {
        return guestsService.updateGuest(updateGuest);
    }

    @DeleteMapping("/removeguest")
    @ApiOperation(value = "deletes single guest", notes = "deletes the guest passed from the hotel system")
    public void removeGuest(@RequestBody Guest removeGuest) {
        guestsService.deleteGuest(removeGuest);
    }
}
