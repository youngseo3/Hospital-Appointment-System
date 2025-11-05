package com.youngseo3.hospitalappointmentsystem.service;

import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateResponse;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationDeleteResponse;
import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import com.youngseo3.hospitalappointmentsystem.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;

    public ReservationCreateResponse saveReservation(ReservationCreateRequest request) {
        Reservation reservation = request.toEntity();
        reservationRepository.save(reservation);

        return ReservationCreateResponse.success(reservation);
    }

    public ReservationDeleteResponse deleteReservation(Long reservationId, ReservationDeleteRequest request) {
        Reservation reservation = reservationRepository.findById(reservationId);
        reservationRepository.delete(reservation);

        log.info("예약 취소 사유: {}", request.getCancelReason());

        return ReservationDeleteResponse.success();
    }
}
