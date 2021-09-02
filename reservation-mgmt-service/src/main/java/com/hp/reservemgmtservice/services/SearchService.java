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
        logger.info("checkIn {}", checkIn);
        logger.info("checkout {}", checkOut);
        try {
            AllRooms allRooms = restTemplate.getForObject(roomsUrl + "allrooms", AllRooms.class);
            logger.info("ALL ROOMS: {}", allRooms.getRooms().stream().count());
            List<Reservations> reservedRooms = reservedRoomsMgmtService.getAllReservations();
            List<Rooms> filtered = allRooms.getRooms();
            for (Reservations reservedRoom : reservedRooms) {
                logger.info("reserved checkin {}", reservedRoom.getCheckInDate());
                logger.info("reserved checkout {}", reservedRoom.getCheckOutDate());
                //||checkIn.isEqual(reservedRoom.getCheckInDate())
                //||checkOut.isEqual(reservedRoom.getCheckOutDate())
                logger.info("Period {}", checkIn.until(checkOut));
                /*reservedRoom.getCheckInDate().isAfter(checkIn)
                        ||
                        reservedRoom.getCheckInDate().equals(checkIn)
                                &&
                                reservedRoom.getCheckOutDate().isBefore(checkOut)
                        ||
                        reservedRoom.getCheckOutDate().isBefore(checkOut)*/
                if (
                        reservedRoom.getCheckInDate().isAfter(checkIn)
                       // checkIn.isAfter(reservedRoom.getCheckInDate())

                                &&
                                reservedRoom.getCheckOutDate().isBefore(checkOut)
                                ||
                                checkIn.isAfter(reservedRoom.getCheckInDate())

                                        &&
                                  checkOut.isBefore(reservedRoom.getCheckOutDate())
                                ||
                                checkIn.equals(reservedRoom.getCheckInDate())
                                ||
                                checkOut.equals(reservedRoom.getCheckOutDate())
                ) {
                    logger.info("checkin after reserve checkin");
                    filtered = allRooms.getRooms().stream().filter(x -> !x.getId().equals(reservedRoom.getRoomId())).collect(Collectors.toList());
                    logger.info("total rooms: {}", filtered.stream().count());

                } else {
                    filtered = allRooms.getRooms();
                }
           /*     if (checkIn.isAfter(reservedRoom.getCheckInDate())
                        && checkOut.isBefore(reservedRoom.getCheckOutDate())) {
                    Reservations r = reservedRoom;
                    logger.info("reserve checkIn {}", r.getCheckInDate());
                    logger.info("reserve checkout {}", r.getCheckOutDate());
                    filtered = allRooms.getRooms().stream().filter(x -> !x.getId().equals(r.getRoomId())).collect(Collectors.toList());
                }*/
            }
            return filtered;
        } catch (Exception e) {
            logger.error("ERROR:" + e);
        }
        return null;
        //  !x.getCheckInDate().after(checkIn)&&!x.getCheckOutDate().before(checkOut)

        //  return null;
    }
}
