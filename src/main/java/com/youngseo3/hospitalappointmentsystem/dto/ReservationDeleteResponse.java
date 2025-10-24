package com.youngseo3.hospitalappointmentsystem.dto;

import lombok.Getter;

@Getter
public class ReservationDeleteResponse {
    private String message;

    private ReservationDeleteResponse(String message) {
        this.message = message;
    }

    public static ReservationDeleteResponse success() {
        return new ReservationDeleteResponse("예약이 취소되었습니다.");
    }

    public static ReservationDeleteResponse failure(String message) {
        return new ReservationDeleteResponse(message);
    }
}