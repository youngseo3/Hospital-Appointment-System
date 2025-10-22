package com.youngseo3.hospitalappointmentsystem.dto;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import lombok.Getter;

@Getter
public class ReservationCreateResponse {
    private Long reservationId;
    private final String message;

    public ReservationCreateResponse(Long reservationId, String message) {
        this.reservationId = reservationId;
        this.message = message;
    }

    public ReservationCreateResponse(String message) {
        this.message = message;
    }

    public static ReservationCreateResponse success(Reservation reservation) {
        return new ReservationCreateResponse(reservation.getId(), "예약이 완료되었습니다.");
    }

    public static ReservationCreateResponse failure(String errorMessage) {
        return new ReservationCreateResponse(errorMessage);
    }
}
