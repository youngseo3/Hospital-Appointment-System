package com.youngseo3.hospitalappointmentsystem.service;

import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateResponse;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteResponse;
import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import com.youngseo3.hospitalappointmentsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationCreateResponse saveReservation(ReservationCreateRequest request) {
        try {
            Reservation reservation = request.toEntity();
            reservationRepository.save(reservation);

            return ReservationCreateResponse.success(reservation);
        } catch (Exception e) {
            return ReservationCreateResponse.failure(e.getMessage());
        }
    }

    public ReservationDeleteResponse deleteReservation(Long reservationId, ReservationDeleteRequest request) {
        try {
            Reservation reservation = reservationRepository.findById(reservationId);
            reservationRepository.delete(reservation);

            System.out.println(request.getCancelReason());
            return ReservationDeleteResponse.success();
        } catch (Exception e) {
            return ReservationDeleteResponse.failure(e.getMessage());
        }
    }
}
