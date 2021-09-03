package com.hp.reservemgmtservice.services;

import com.hp.reservemgmtservice.models.guests.Guest;
import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.Rooms;
import com.hp.reservemgmtservice.repos.ReservedRoomsMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

@Service
public class ReservationService {
    @Autowired
    ReservedRoomsMgmtService reservedRoomsMgmtService;
    private String roomsUrl = "http://case-rooms/";

    @Autowired
    RestTemplate restTemplate;

    public Reservations addReservation(Reservations reservations) {
        int numberOfNights =
                reservations.getCheckInDate().until(reservations.getCheckOutDate()).getDays();
        reservations.setNumberOfNights(numberOfNights);
        Rooms room = restTemplate.getForObject(roomsUrl + "rooms/" + reservations.getRoomId(), Rooms.class);
        reservations.setPrice(room.getPrice());
        reservations.setRoomNo(room.getRoomNumber());

        if (!reservations.getGuests().isEmpty()) {
                reservations.getGuests().forEach(x-> {
                    try {
                        sendmail(
                                x,reservations.getCheckInDate(),reservations.getCheckOutDate()
                        );
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
               // sendmail(reservations);

        }
        return reservedRoomsMgmtService.saveReservations(reservations);
    }

    public void sendmail(Guest guest, LocalDate checkInDate, LocalDate checkOutDate) throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(
                        "hphms2021@gmail.com", "HMS@2021");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("harsh2256@gmail.com", false));
        String rec = guest.getEmail();
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(rec));
        msg.setSubject("HMS Reservation");
        msg.setContent(
                "Hotel Reservation"

                ,
                "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent("This email is regarding the reservation of your room in Hotel on "
                + checkInDate
                + " to " + checkOutDate, "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();

        //  attachPart.attachFile("/var/tmp/image19.png");
        //   multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

}
