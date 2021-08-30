package com.hp.reservemgmtservice.repos;

import com.hp.reservemgmtservice.dao.ReservedRoomsDao;
import com.hp.reservemgmtservice.models.reserved.Reservations;
import com.hp.reservemgmtservice.models.rooms.Rooms;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ReservedRoomsMgmtService implements ReservedRoomsDao {
    /* @Autowired
     private ReservedRoomsDao reservedRoomsDao;
 */
    @Autowired
    RestTemplate restTemplate;
    private String roomsUrl = "http://case-rooms/";

    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReservedRoomsMgmtService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Reservations saveReservations(Reservations reservations) {
       /* Query query = new Query();
        query.addCriteria(Criteria.where(reservations).is(reservations));
        return  mongoTemplate.find*/
        try {
            Rooms room = restTemplate.getForObject(roomsUrl + "rooms/" + reservations.getRoomId(), Rooms.class);
            reservations.setPrice(room.getPrice());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mongoTemplate.save(reservations);
    }

    @Override
    public List<Reservations> getAllReservations() {
        return mongoTemplate.findAll(Reservations.class);
    }

    @Override
    public List<Reservations> getAllReservationsPaginated(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public Reservations findOneById(String id) {
        return mongoTemplate.findById(id, Reservations.class);
    }

    @Override
    public void updateMultipleReservations() {

    }

    @Override
    public Reservations updateOneReservations(Reservations reservations) {
        mongoTemplate.save(reservations);
        return reservations;
    }

    @Override
    public void deleteReservations(Reservations reservations) {
        mongoTemplate.remove(reservations);
    }
/*
    public List<Reservations> getAll() {
        List<Reservations> all = new ArrayList<>(reservedRoomsDao.getAllReservations());
        return all;
    }

    public Reservations getreservation(String id) {
        Query
    }

    public void addreservations(Reservations reservations) {
        reservedRoomsDao.save(reservations);
    }

    public void updatereservations(Reservations reservations) {
        reservedRoomsDao.save(reservations);
    }

 *//*   public void deletereservations(String id) {
        reservationsRepository.deleteById(Integer.parseInt(id));
    }*//*
    public void deletereservationsById(String id){
        reservedRoomsDao.deleteReservationById(id);
    }*/
}
