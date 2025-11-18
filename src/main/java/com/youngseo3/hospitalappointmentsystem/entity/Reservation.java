package com.youngseo3.hospitalappointmentsystem.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class Reservation {
    @Setter
    private Long id;
    private Long patientId;
    private Long doctorId;
    private LocalDateTime reservationStartTime;
    private LocalDateTime reservationEndTime;
    private String reason;

    public Reservation(Long patientId, Long doctorId, LocalDateTime reservationStartTime, LocalDateTime reservationEndTime, String reason) {
        validateReservationTime(reservationStartTime, reservationEndTime);

        this.patientId = patientId;
        this.doctorId = doctorId;
        this.reservationStartTime = reservationStartTime;
        this.reservationEndTime = reservationEndTime;
        this.reason = reason;
    }

    public boolean isEqualsReservationTime(Reservation other) {
        return reservationStartTime.equals(other.getReservationStartTime()) &&
                reservationEndTime.equals(other.getReservationEndTime());
    }

    private void validateReservationTime(LocalDateTime reservationStartTime, LocalDateTime reservationEndTime) {
        LocalTime treamentStartTime = LocalTime.of(9, 0);
        LocalTime treamentEndTime = LocalTime.of(17, 0);

        LocalTime startTime = reservationStartTime.toLocalTime();
        LocalTime endTime = reservationEndTime.toLocalTime();

        if(!(!startTime.isBefore(treamentStartTime) && !startTime.isAfter(treamentEndTime)) || startTime.getMinute() != 0) {
            throw new IllegalArgumentException("의사의 진료 가능 시간(09:00~17:00) 내에서만 예약할 수 있습니다");
        }

        if(!(!endTime.isBefore(treamentStartTime) && !endTime.isAfter(treamentEndTime)) || endTime.getMinute() != 0) {
            throw new IllegalArgumentException("의사의 진료 가능 시간(09:00~17:00) 내에서만 예약할 수 있습니다");
        }
    }
}