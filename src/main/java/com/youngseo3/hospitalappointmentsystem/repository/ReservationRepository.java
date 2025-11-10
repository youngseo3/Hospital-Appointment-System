package com.youngseo3.hospitalappointmentsystem.repository;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class ReservationRepository {
    private final List<Reservation> reservations;
    private Long id = 1L;

    public synchronized void save(Reservation reservation) {
        isTimeOverlapping(reservation);
        reservation.setId(id++);
        reservations.add(reservation);
    }

    public Reservation findById(Long id) {
        for (Reservation reservation: reservations) {
            if (reservation.getId().equals(id)) {
                return reservation;
            }
        }

        throw new IllegalArgumentException("존재하지 않는 예약입니다.");
    }

    public void delete(Reservation reservation) {
        reservations.remove(reservation);
    }

    private void isTimeOverlapping(Reservation other) {
        for (Reservation reservation: reservations) {
            if (reservation.isEqualsReservationTime(other)) {
                throw new IllegalArgumentException("해당 시간에는 이미 예약이 있습니다. 다른 시간을 선택해주세요.");
            }
        }
    }

    public List<Reservation> findAll() {
        return reservations;
    }
}
