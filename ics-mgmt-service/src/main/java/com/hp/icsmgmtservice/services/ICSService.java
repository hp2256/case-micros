package com.hp.icsmgmtservice.services;

import com.hp.icsmgmtservice.models.Inventory;
import com.hp.icsmgmtservice.repos.ICSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ICSService {
    @Autowired
    private ICSRepository ICSRepository;


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

    public void addInventory(Inventory inventory) {
        ICSRepository.insert(inventory);
    }

    public void updateInventory(Inventory inventory) {
        ICSRepository.save(inventory);
    }

 /*   public void deleteInventory(String id) {
        staffRepository.deleteById(Integer.parseInt(id));
    }*/
    public void deleteInventoryById(String id){
        ICSRepository.deleteInventoryById(id);
    }
}
