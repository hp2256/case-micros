package com.hp.reservemgmtservice.models.rooms;

import java.util.List;

public class AllRooms {
    List<Rooms> rooms;

    AllRooms(){}

    public List<Rooms> getRooms() {
        return rooms;
    }

    public void setRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }

    public AllRooms(List<Rooms> rooms) {
        this.rooms = rooms;
    }
}
