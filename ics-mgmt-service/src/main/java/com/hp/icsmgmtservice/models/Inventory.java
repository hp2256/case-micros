package com.hp.icsmgmtservice.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "inventory")
public class Inventory {
    @Id
    private String id;
    private int rooms;
    private int parking;
    
}
