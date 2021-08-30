package com.hp.roomsmgmtservice.controllers;

import com.hp.roomsmgmtservice.models.AllRooms;
import com.hp.roomsmgmtservice.models.Rooms;
import com.hp.roomsmgmtservice.services.RoomsMgmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*",allowedHeaders ="*")
public class RoomsController {

    @Autowired
    RoomsMgmtService roomsService;

    Logger logger = LoggerFactory.getLogger(RoomsController.class);
    @GetMapping("/allrooms")
    public AllRooms getAllrooms(){
        return new AllRooms(roomsService.getAll());
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    @GetMapping("/rooms/{id}")
    public Rooms getRoom(@PathVariable String id){
        return roomsService.getrooms(id);
    }
    @PostMapping("/addroom")
    public Rooms addRooms(@RequestBody Rooms newRooms){
        Rooms room = roomsService.addrooms(newRooms);
        logger.info("room {}",room.getId());
        return room;
    }

    @PutMapping(value = "/updateroom")
    public void updateRoom(@RequestBody Rooms rooms) {
        roomsService.updaterooms(rooms);
    }
    @DeleteMapping("/deleterooms/{id}")
    public void removeRoom(@PathVariable String id){
        roomsService.deleteroomsById(id);
    }

}
