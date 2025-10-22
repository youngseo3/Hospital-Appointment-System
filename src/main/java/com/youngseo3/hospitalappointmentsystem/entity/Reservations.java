package com.youngseo3.hospitalappointmentsystem.entity;

import com.youngseo3.hospitalappointmentsystem.global.EntityIdGenerator;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Reservations {
    @Getter
    private static final Reservations instance = new Reservations();
    private final EntityIdGenerator entityIdGenerator = EntityIdGenerator.getInstance();
    private final List<Reservation> items;

    private Reservations() {
        this.items = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        isTimeOverlapping(reservation);

        items.add(reservation);
        entityIdGenerator.addReservationId();
    }

    private void isTimeOverlapping(Reservation other) {
        for(Reservation reservation: items) {
            if(reservation.isEqualsReservationTime(other)) {
                throw new IllegalArgumentException("해당 시간에는 이미 예약이 있습니다. 다른 시간을 선택해주세요.");
            }
        }
    }
}
