package com.youngseo3.hospitalappointmentsystem.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ReservationDeleteRequest {
    private String cancelReason;
}
