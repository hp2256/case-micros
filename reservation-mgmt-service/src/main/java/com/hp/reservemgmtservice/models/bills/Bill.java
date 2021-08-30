package com.hp.reservemgmtservice.models.bills;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "bills")
public class Bill {
    @Id
    String id;
    int numberOfNights;
    Double price;
    Float taxes;
    String services;
    int unit;
    boolean paidStatus;
    String reservationId;

    Bill() {
    }

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(String reservationId) {
        this.reservationId = reservationId;
    }

    public Bill(String id, int numberOfNights, Double price, Float taxes, String services, int unit, boolean paidStatus, String reservationId) {
        this.id = id;
        this.numberOfNights = numberOfNights;
        this.price = price;
        this.taxes = taxes;
        this.services = services;
        this.unit = unit;
        this.paidStatus = paidStatus;
        this.reservationId = reservationId;
    }

    public boolean isPaidStatus() {
        return paidStatus;
    }

    public void setPaidStatus(boolean paidStatus) {
        this.paidStatus = paidStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumberOfNights() {
        return numberOfNights;
    }

    public void setNumberOfNights(int numberOfNights) {
        this.numberOfNights = numberOfNights;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Float getTaxes() {
        return taxes;
    }

    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
