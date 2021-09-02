package com.hp.roomsmgmtservice.repos;

import com.hp.roomsmgmtservice.models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICSRepository extends MongoRepository<Inventory,String>{
    Long deleteInventoryById(String id);
}
