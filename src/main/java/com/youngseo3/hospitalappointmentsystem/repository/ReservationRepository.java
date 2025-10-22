package com.youngseo3.hospitalappointmentsystem.repository;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import com.youngseo3.hospitalappointmentsystem.entity.Reservations;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationRepository {
    private final Reservations reservations = Reservations.getInstance();

    public void save(Reservation reservation) {
        reservations.addReservation(reservation);
    }
}
