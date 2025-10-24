package com.youngseo3.hospitalappointmentsystem.global;

import lombok.Getter;


public class EntityIdGenerator {
    @Getter
    private static final EntityIdGenerator instance = new EntityIdGenerator();

    @Getter
    private Long reservationId;

    private EntityIdGenerator() {
        reservationId = 1L;
    }

    public void addReservationId() {
        reservationId++;
    }
}
