package com.hp.icsmgmtservice.controllers;

import com.hp.icsmgmtservice.models.AllInventory;
import com.hp.icsmgmtservice.models.Inventory;
import com.hp.icsmgmtservice.services.ICSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",allowedHeaders ="*")
public class ICSController {

    @Autowired
    ICSService ICSService;

    @GetMapping("/allinventory")
    public AllInventory getAllInventory(){
        AllInventory allInventory = new AllInventory();
        allInventory.setInventory(ICSService.getAll());
        return allInventory;
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    @GetMapping("/inventory/{id}")
    public Inventory getInventory(@PathVariable String id){
        return ICSService.getInventory(id);
    }
    @PostMapping("/addinventory")
    public void addInventory(@RequestBody Inventory newInventory){
        ICSService.addInventory(newInventory);
    }

    @PutMapping(value = "/updateinventory")
    public void updateInventory(@RequestBody Inventory inventory) {
        ICSService.updateInventory(inventory);
    }
    @DeleteMapping("/deleteinventory/{id}")
    public void removeInventory(@PathVariable String id){
        ICSService.deleteInventoryById(id);
    }

}
