package com.hp.roomsmgmtservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
public class Rooms {
    @Id
    private String id;

    private int roomNumber;
    private String type;
    private int typeId;
    private boolean smoke;
    private double price;

    public Rooms(String id, int roomNumber, String type, int typeId, boolean smoke, double price) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.typeId = typeId;
        this.smoke = smoke;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }
}
