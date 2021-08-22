package com.hp.guestsmgmtservice.services;

import com.hp.guestsmgmtservice.models.Guest;
import com.hp.guestsmgmtservice.repos.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GuestsService {
    @Autowired
    private GuestRepository guestRepository;


    public List<Guest> getAll() {
        List<Guest> all = new ArrayList<>(guestRepository.findAll());
        return all;
    }

    public Guest getGuest(int id) {
        if (guestRepository.findById(id).isPresent())
            return guestRepository.findById(id).get();
        else
            return null;
    }

    public void addGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void updateGuest(Guest guest) {
        guestRepository.save(guest);
    }

    public void deleteGuest(Guest guest) {
        guestRepository.delete(guest);
    }
}
