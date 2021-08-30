package com.hp.guestsmgmtservice.controllers;

import com.hp.guestsmgmtservice.models.Guest;
import com.hp.guestsmgmtservice.services.GuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class GuestController {

    @Autowired
    GuestsService guestsService;

    @GetMapping("/allguests")
    public List<Guest> getAllGuests() {
        return guestsService.getAll();
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/

    @PostMapping("/addguest")
    public Guest addGuest(@RequestBody Guest newGuest) {
        return guestsService.addGuest(newGuest);
    }

    @PutMapping("/updateguest")
    public Guest updateGuest(@RequestBody Guest updateGuest) {
        return guestsService.updateGuest(updateGuest);
    }

    @DeleteMapping("/removeguest")
    public void removeGuest(@RequestBody Guest removeGuest) {
        guestsService.deleteGuest(removeGuest);
    }
}
