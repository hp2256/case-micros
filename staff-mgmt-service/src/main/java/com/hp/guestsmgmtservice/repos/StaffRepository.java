package com.hp.guestsmgmtservice.repos;

import com.hp.guestsmgmtservice.models.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff,Integer>{
}
