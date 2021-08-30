package com.hp.reservemgmtservice.models.reserved;

import java.util.List;

public class AllReservations {
    List<Reservations> reservations;

    AllReservations(){
    }

    public AllReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    public List<Reservations> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }
}
