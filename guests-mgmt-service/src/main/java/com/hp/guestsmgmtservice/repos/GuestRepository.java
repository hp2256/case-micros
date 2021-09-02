package com.hp.guestsmgmtservice.repos;

import com.hp.guestsmgmtservice.models.Guest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GuestRepository extends MongoRepository<Guest,String>{
}
