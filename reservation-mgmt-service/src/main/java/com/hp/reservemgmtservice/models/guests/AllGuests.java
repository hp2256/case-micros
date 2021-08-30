package com.hp.reservemgmtservice.models.guests;

import java.util.List;

public class AllGuests {
    private List<Guest> guestList;

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    public AllGuests(List<Guest> guestList) {
        this.guestList = guestList;
    }
}
