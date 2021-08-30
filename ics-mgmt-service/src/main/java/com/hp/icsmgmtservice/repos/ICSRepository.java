package com.hp.icsmgmtservice.repos;

import com.hp.icsmgmtservice.models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICSRepository extends MongoRepository<Inventory,String>{
    Long deleteInventoryById(String id);
}
