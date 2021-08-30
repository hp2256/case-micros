package com.hp.roomsmgmtservice.repos;

import com.hp.roomsmgmtservice.models.Rooms;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomsRepository extends MongoRepository<Rooms,String>{
    Long deleteRoomById(String id);
}
