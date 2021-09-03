package com.hp.reservemgmtservice.controllers;

import com.hp.reservemgmtservice.models.bills.AllBills;
import com.hp.reservemgmtservice.models.bills.Bill;
import com.hp.reservemgmtservice.models.payments.Payments;
import com.hp.reservemgmtservice.models.reserved.AllReservations;
import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.AllRooms;
import com.hp.reservemgmtservice.repos.BillsRepo;
import com.hp.reservemgmtservice.repos.PaymentRepo;
import com.hp.reservemgmtservice.repos.ReservedRoomsMgmtService;
import com.hp.reservemgmtservice.services.BillGenerate;
import com.hp.reservemgmtservice.services.ReservationService;
import com.hp.reservemgmtservice.services.SearchService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@RestController
@RequestMapping("/")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ReservationsController {

    @Autowired
    ReservedRoomsMgmtService reservedRoomsMgmtService;

    Logger logger = LoggerFactory.getLogger(ReservationsController.class);
    @Autowired
    SearchService searchService;

    @Autowired
    ReservationService reservationService;
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    BillGenerate billGenerate;
    @Autowired
    BillsRepo billsRepo;

    @Autowired
    PaymentRepo paymentRepo;
    private String roomsUrl = "http://case-rooms/";

    @GetMapping("/allreservations")
    @ApiOperation(value = "All the reservations", notes = "Fetches all the reservations in the hotel")
    public AllReservations getAllrooms() {
        return new AllReservations(reservedRoomsMgmtService.getAllReservations());

        //new AllRooms(roomsService.getAllReservations());
    }

    //search providing dates
    @GetMapping("/search/{checkIn}/{checkOut}")
    @ApiOperation(value = "search rooms", notes = "searches rooms by given checkin and checkout date in the hotel")

    //search/{source}/{dest}/{date}
    public AllRooms getRooms(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkIn,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate checkOut) {
        logger.info("check in date {} and check out date {}", checkIn, checkOut);
        if (searchService.searchRooms(checkIn, checkOut) != null) {
            return new AllRooms(searchService.searchRooms(checkIn, checkOut));
        }
        return null;
    }

    @PostMapping("/addreservation")
    @ApiOperation(value = "add the reservation", notes = "adds a reservation in the hotel")

    public Reservations addReservation(@RequestBody Reservations reservations) {
        try {
            return reservationService.addReservation(reservations);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
        // return reservationService.saveReservations(reservations);
    }

    @GetMapping("/reservations/{id}")
    @ApiOperation(value = "get the reservation", notes = "Fetches the given reservation in the hotel")

    public Reservations getReservations(@PathVariable String id) {
        return reservedRoomsMgmtService.findOneById(id);
    }

    @PutMapping("/updatereservations")
    @ApiOperation(value = "updates the reservation", notes = "Updates the reservation in the hotel")
    public Reservations udpateRates(@RequestBody Reservations reservations) {
        return reservedRoomsMgmtService.updateOneReservations(reservations);
    }
    //billing mappings

    //create the bill
    @PostMapping("/issuebill")
    @ApiOperation(value = "issues a bill", notes = "Issues a bill and if it exists returns existing bill")

    public Bill addBill(@RequestBody Reservations reservations) {
        if (reservations.getBillId() == null || reservations.getBillId().equals("")) {
            return billGenerate.issueBill(reservations);
        } else return billsRepo.findOneById(reservations.getBillId());
    }

    //get a single bill by id
    @GetMapping("/getbill/{id}")
    @ApiOperation(value = "gets a bill", notes = "gets a bill by its id")
    public Bill getBill(@PathVariable String id) {
        return billsRepo.findOneById(id);
    }


    @GetMapping("/getbills")
    @ApiOperation(value = "gets all bills", notes = "gets all the bills")
    public AllBills getAllBills() {
        return new AllBills(billsRepo.getAllBills());
    }


    //add credit cards
    @PostMapping("/addpayment")
    @ApiOperation(value = "adds a payment", notes = "adds a payment and updates bill which inturn updates the reservation")
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
