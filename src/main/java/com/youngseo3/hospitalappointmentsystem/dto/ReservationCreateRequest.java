package com.youngseo3.hospitalappointmentsystem.dto;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor
@Setter
@Getter
public class ReservationCreateRequest {
    private Long patientId;
    private Long doctorId;
    private LocalDateTime reservationTime;
    private String reason;

    public Reservation toEntity() {
        return new Reservation(patientId, doctorId, reservationTime, reason);
    }
}
