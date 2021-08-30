package com.hp.reservemgmtservice.controllers;

import com.hp.reservemgmtservice.models.Payments;
import com.hp.reservemgmtservice.models.bills.AllBills;
import com.hp.reservemgmtservice.models.bills.Bill;
import com.hp.reservemgmtservice.models.reserved.AllReservations;
import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.AllRooms;
import com.hp.reservemgmtservice.repos.BillsRepo;
import com.hp.reservemgmtservice.repos.PaymentRepo;
import com.hp.reservemgmtservice.repos.ReservedRoomsMgmtService;
import com.hp.reservemgmtservice.services.BillGenerate;
import com.hp.reservemgmtservice.services.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class RoomsController {

    @Autowired
    ReservedRoomsMgmtService reservationService;

    Logger logger = LoggerFactory.getLogger(RoomsController.class);
    @Autowired
    SearchService searchService;

    @Autowired
    BillGenerate billGenerate;
    @Autowired
    BillsRepo billsRepo;

    @Autowired
    PaymentRepo paymentRepo;

    @GetMapping("/allreservations")
    public AllReservations getAllrooms() {
        return new AllReservations(reservationService.getAllReservations());

        //new AllRooms(roomsService.getAllReservations());
    }

    //search providing dates
    @GetMapping("/search/{checkIn}/{checkOut}")
    public AllRooms getRooms(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut) {
        logger.info("check in date {} and check out date {}", checkIn, checkOut);
        return new AllRooms(searchService.searchRooms(checkIn, checkOut));
    }

    @PostMapping("/addreservation")
    public Reservations addReservation(@RequestBody Reservations reservations) {
        int numberOfNights =
                reservations.getCheckInDate().until(reservations.getCheckOutDate()).getDays();
        reservations.setNumberOfNights(numberOfNights);
        return reservationService.saveReservations(reservations);
    }

    @GetMapping("/reservations/{id}")
    public Reservations getReservations(@PathVariable String id) {
        return reservationService.findOneById(id);
    }

    @PutMapping("/updatereservations")
    public Reservations udpateRates(@RequestBody Reservations reservations) {
        return reservationService.updateOneReservations(reservations);
    }
    //billing mappings

    //create the bill
    @PostMapping("/issuebill")
    public Bill addBill(@RequestBody Reservations reservations) {
        if (reservations.getBillId() == null || reservations.getBillId().equals("")) {
            return billGenerate.issueBill(reservations);
        } else return null;
    }

    //get a single bill by id
    @GetMapping("/getbill/{id}")
    public Bill getBill(@PathVariable String id) {
        return billsRepo.findOneById(id);
    }


    @GetMapping("/getbills")
    public AllBills getAllBills() {
        return new AllBills(billsRepo.getAllBills());
    }


    //add credit cards
    @PostMapping("/addpayment")
    public Payments addPayment(@RequestBody Payments payments) {
        return paymentRepo.addPayments(payments);
    }











   /* @GetMapping("/all")
    public Guests getAll(){
        return guestsService.getAllGuests();
    }*/
    /*
    @GetMapping("/rooms/{id}")
    public Rooms getRoom(@PathVariable String id){
        return roomsService.getrooms(id);
    }
    @PostMapping("/addroom")
    public void addRooms(@RequestBody Rooms newRooms){
        roomsService.addrooms(newRooms);
    }

    @PutMapping(value = "/updateroom")
    public void updateRoom(@RequestBody Rooms rooms) {
        roomsService.updaterooms(rooms);
    }
    @DeleteMapping("/deleterooms/{id}")
    public void removeRoom(@PathVariable String id){
        roomsService.deleteroomsById(id);
    }*/

}
