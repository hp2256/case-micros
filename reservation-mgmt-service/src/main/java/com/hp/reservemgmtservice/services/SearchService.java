package com.hp.reservemgmtservice.services;

import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.AllRooms;
import com.hp.reservemgmtservice.models.rooms.Rooms;
import com.hp.reservemgmtservice.repos.ReservedRoomsMgmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ReservedRoomsMgmtService reservedRoomsMgmtService;

    Logger logger = LoggerFactory.getLogger(SearchService.class);

    private String roomsUrl = "http://case-rooms/";

    public List<Rooms> searchRooms(LocalDate checkIn, LocalDate checkOut) {
        try {
            AllRooms allRooms = restTemplate.getForObject(roomsUrl + "allrooms", AllRooms.class);
            List<Reservations> reservedRooms = reservedRoomsMgmtService.getAllReservations();
            List<Rooms> filtered = allRooms.getRooms();
            for (int i = 0; i < reservedRooms.size(); i++) {
                if (checkIn.isAfter(reservedRooms.get(i).getCheckInDate())
                        && checkOut.isBefore(reservedRooms.get(i).getCheckOutDate())) {
                    Reservations r = reservedRooms.get(i);
                    filtered = allRooms.getRooms().stream().filter(x -> !x.getId().equals(r.getRoomId())).collect(Collectors.toList());
                }
            }
            return filtered;
        }
        catch (Exception e){
            logger.error("ERROR:" +e);
        }
        return null;
      //  !x.getCheckInDate().after(checkIn)&&!x.getCheckOutDate().before(checkOut)

      //  return null;
    }
}
