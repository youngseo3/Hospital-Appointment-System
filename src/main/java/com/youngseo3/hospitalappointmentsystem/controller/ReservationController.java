package com.youngseo3.hospitalappointmentsystem.controller;

import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateResponse;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteResponse;
import com.youngseo3.hospitalappointmentsystem.global.ApiResponse;
import com.youngseo3.hospitalappointmentsystem.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/reservations")
@RestController
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ApiResponse<ReservationCreateResponse>> saveReservation(@RequestBody ReservationCreateRequest request) {
        try {
            ReservationCreateResponse response = reservationService.saveReservation(request);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.onSuccess(response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(ApiResponse.onFailure(e.getMessage()));
        }
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<ApiResponse<ReservationDeleteResponse>> deleteReservation(
            @PathVariable Long reservationId,
            @RequestBody ReservationDeleteRequest request) {
        try {
            ReservationDeleteResponse response = reservationService.deleteReservation(reservationId, request);
            return ResponseEntity.ok(ApiResponse.onSuccess(response));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.onFailure(e.getMessage()));
        }
    }
}
