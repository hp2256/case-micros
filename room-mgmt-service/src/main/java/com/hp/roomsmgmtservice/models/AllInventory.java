package com.hp.roomsmgmtservice.models;

import java.util.List;

public class AllInventory {
        List<Inventory> inventories;

    public List<Inventory> getInventory() {
        return inventories;
    }

    public void setInventory(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
