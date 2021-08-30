package com.hp.reservemgmtservice.dao;

import com.hp.reservemgmtservice.models.reserved.Reservations;

import java.util.List;

public interface ReservedRoomsDao {
    Reservations saveReservations(Reservations reservations);

    List<Reservations> getAllReservations();

    List<Reservations> getAllReservationsPaginated(
            int pageNumber, int pageSize);

    Reservations findOneById(String id);

    //   List<Reservations> findByAgeRange(int lowerBound, int upperBound);

    void updateMultipleReservations();

    Reservations updateOneReservations(Reservations reservations);

    void deleteReservations(Reservations reservations);
}
