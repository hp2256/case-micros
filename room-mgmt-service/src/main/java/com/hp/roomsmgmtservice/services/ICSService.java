package com.hp.roomsmgmtservice.services;

import com.hp.roomsmgmtservice.models.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ICSService {
    @Autowired
    private com.hp.roomsmgmtservice.repos.ICSRepository ICSRepository;


    public List<Inventory> getAll() {
        List<Inventory> all = new ArrayList<>(ICSRepository.findAll());
        return all;
    }

    public Inventory getInventory(String id) {
        if (ICSRepository.findById(id).isPresent())
            return ICSRepository.findById(id).get();
        else
            return null;
    }

    public Inventory addInventory(Inventory inventory) {
        return ICSRepository.insert(inventory);
    }

    public Inventory updateInventory(Inventory inventory) {
        return ICSRepository.save(inventory);
    }

    /*   public void deleteInventory(String id) {
           staffRepository.deleteById(Integer.parseInt(id));
       }*/
    public void deleteInventoryById(String id) {
        ICSRepository.deleteInventoryById(id);
    }
}
