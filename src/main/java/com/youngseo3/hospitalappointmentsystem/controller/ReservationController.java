package com.youngseo3.hospitalappointmentsystem.controller;

import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateResponse;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteResponse;
import com.youngseo3.hospitalappointmentsystem.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationCreateResponse> saveReservation(@RequestBody ReservationCreateRequest request) {
        ReservationCreateResponse response = reservationService.saveReservation(request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<ReservationDeleteResponse> deleteReservation(
            @PathVariable Long reservationId,
            @RequestBody ReservationDeleteRequest request) {
        ReservationDeleteResponse response = reservationService.deleteReservation(reservationId, request);
        return ResponseEntity.ok(response);
    }
}
