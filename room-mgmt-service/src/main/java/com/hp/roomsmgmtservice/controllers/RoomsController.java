package com.hp.roomsmgmtservice.controllers;

import com.hp.roomsmgmtservice.models.AllRooms;
import com.hp.roomsmgmtservice.models.Rooms;
import com.hp.roomsmgmtservice.services.RoomsMgmtService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "*",allowedHeaders ="*")
public class RoomsController {

    @Autowired
    RoomsMgmtService roomsService;

    Logger logger = LoggerFactory.getLogger(RoomsController.class);
    @GetMapping("/allrooms")
    @ApiOperation(value = "All the rooms", notes = "Fetches all the rooms in the hotel")
    public AllRooms getAllrooms(){
        return new AllRooms(roomsService.getAll());
    }

   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    @GetMapping("/rooms/{id}")
    @ApiOperation(value = "Single room", notes = "Fetches single room by id in the hotel")
    public Rooms getRoom(@PathVariable String id){
        return roomsService.getrooms(id);
    }


    @PostMapping("/addroom")
    @ApiOperation(value = "add single room", notes = "adds the room in the hotel")
    public Rooms addRooms(@RequestBody Rooms newRooms){
        Rooms room = roomsService.addrooms(newRooms);
        logger.info("room {}",room.getId());
        return room;
    }

    @PutMapping(value = "/updateroom")
    @ApiOperation(value = "update single room", notes = "updates the room passed in the hotel system")
    public void updateRoom(@RequestBody Rooms rooms) {
        roomsService.updaterooms(rooms);
    }

    @DeleteMapping("/deleterooms/{id}")
    @ApiOperation(value = "deletes room staff", notes = "deletes the room passed from the hotel system")
    public void removeRoom(@PathVariable String id){
        roomsService.deleteroomsById(id);
    }

}
