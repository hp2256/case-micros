package com.hp.staffmgmtservice.repos;

import com.hp.staffmgmtservice.models.Staff;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StaffRepository extends MongoRepository<Staff,String>{
    Long deleteStaffById(String id);
}
