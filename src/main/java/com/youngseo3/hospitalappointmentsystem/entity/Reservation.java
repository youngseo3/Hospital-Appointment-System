package com.youngseo3.hospitalappointmentsystem.entity;


import com.youngseo3.hospitalappointmentsystem.global.EntityIdGenerator;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class Reservation {
    private final EntityIdGenerator entityIdGenerator = EntityIdGenerator.getInstance();
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime reservationTime;
    private String reason;

    public Reservation(Long patientId, Long doctorId, LocalDateTime reservationTime, String reason) {
        this.id = entityIdGenerator.getReservationId();
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.reservationTime = reservationTime;
        this.reason = reason;

        validateReservationTime();
    }

    private void validateReservationTime() {
        LocalTime time = reservationTime.toLocalTime();

        LocalTime startTime = LocalTime.of(9, 0);
        LocalTime endTime = LocalTime.of(17, 0);

        if(!(!time.isBefore(startTime) && !time.isAfter(endTime)) || time.getMinute() != 0) {
           throw new IllegalArgumentException("의사의 진료 가능 시간(09:00~17:00) 내에서만 예약할 수 있습니다");
        }
    }

    public boolean isEqualsReservationTime(Reservation other) {
        return reservationTime.equals(other.getReservationTime());
    }

    public boolean isEqualsId(Long id) {
        return this.id.equals(id);
    }
}