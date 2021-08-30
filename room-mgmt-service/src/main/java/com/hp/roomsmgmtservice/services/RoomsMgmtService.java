package com.hp.roomsmgmtservice.services;

import com.hp.roomsmgmtservice.models.Rooms;
import com.hp.roomsmgmtservice.repos.RoomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomsMgmtService {
    @Autowired
    private RoomsRepository roomsRepository;


    public List<Rooms> getAll() {
        List<Rooms> all = new ArrayList<>(roomsRepository.findAll());
        return all;
    }

    public Rooms getrooms(String id) {
        if (roomsRepository.findById(id).isPresent())
            return roomsRepository.findById(id).get();
        else
            return null;
    }

    public Rooms addrooms(Rooms rooms) {
        return roomsRepository.save(rooms);
    }

    public void updaterooms(Rooms rooms) {
        roomsRepository.save(rooms);
    }

 /*   public void deleterooms(String id) {
        roomsRepository.deleteById(Integer.parseInt(id));
    }*/
    public void deleteroomsById(String id){
        roomsRepository.deleteRoomById(id);
    }
}
