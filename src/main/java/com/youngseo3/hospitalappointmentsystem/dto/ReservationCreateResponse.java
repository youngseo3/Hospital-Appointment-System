package com.youngseo3.hospitalappointmentsystem.dto;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import lombok.Getter;

@Getter
public class ReservationCreateResponse {
    private final Long reservationId;
    private final String message;
    private final int calculatedFee;

    private ReservationCreateResponse(Long reservationId, String message, int calculatedFee) {
        this.reservationId = reservationId;
        this.message = message;
        this.calculatedFee = calculatedFee;
    }

    public static ReservationCreateResponse success(Reservation reservation, int calculatedFee) {
        return new ReservationCreateResponse(reservation.getId(), "예약이 완료되었습니다.", calculatedFee);
    }
}
