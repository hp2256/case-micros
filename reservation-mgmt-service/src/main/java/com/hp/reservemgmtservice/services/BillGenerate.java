package com.hp.reservemgmtservice.services;

import com.hp.reservemgmtservice.models.bills.Bill;
import com.hp.reservemgmtservice.models.reserved.AllReservations;
import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.Rooms;
import com.hp.reservemgmtservice.repos.BillsMongoRepo;
import com.hp.reservemgmtservice.repos.BillsRepo;
import com.hp.reservemgmtservice.repos.ReservedRoomsMgmtService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class BillGenerate {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ReservedRoomsMgmtService reservedRoomsMgmtService;

    @Autowired
    BillsMongoRepo billsMongoRepo;
    Logger logger = LoggerFactory.getLogger(SearchService.class);

    @Autowired
    BillsRepo billsRepo;
    private String roomsUrl = "http://case-rooms/";

    public Bill issueBill(Reservations reservations) {
        Reservations reservations1 = reservations;
        logger.info("Reservation: {}" + reservations1.getId());
        Rooms room = restTemplate.getForObject(roomsUrl + "rooms/" + reservations1.getRoomId(), Rooms.class);
        int billId = billsRepo.getAllBills().size();
        Bill newBill = billsRepo.saveBill(
                new Bill(
                        String.valueOf(billId),
                        reservations1.getNumberOfNights(),
                        (room.getPrice() * reservations1.getNumberOfNights()),
                        (float) ((room.getPrice() * reservations1.getNumberOfNights()) * 0.18),
                        room.getType(),
                        room.getRoomNumber(),
                        false,
                        reservations1.getId()
                )
        );
        logger.info("Bill id {}", newBill.getId());
        reservations1.setBillId(String.valueOf(billId));
        reservedRoomsMgmtService.saveReservations(reservations1);
        return newBill;
    }


    public void generateBills() {
        AllReservations allReservations = new AllReservations(reservedRoomsMgmtService.getAllReservations());
        allReservations.getReservations().stream()
                .filter(x -> x.getCheckOutDate().isAfter(LocalDate.now()))
                .forEach(b -> {
                    for (Bill bill : billsRepo.getAllBills()) {
                        if (!bill.isPaidStatus()) {
                            Rooms room = restTemplate.getForObject(roomsUrl + "rooms/" + b.getRoomId(), Rooms.class);
                            billsRepo.saveBill(
                                    new Bill(
                                            "",
                                            b.getNumberOfNights(),
                                            room.getPrice(),
                                            (float) (room.getPrice() * 0.18),
                                            room.getType(),
                                            room.getRoomNumber(),
                                            false,
                                            b.getId()
                                    )
                            );
                        }
                    }
                });
    }
}
