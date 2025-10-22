package com.youngseo3.hospitalappointmentsystem.controller;

import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateRequest;
import com.youngseo3.hospitalappointmentsystem.dto.ReservationCreateResponse;
import com.youngseo3.hospitalappointmentsystem.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {
    /*
     1. 왜 생성자로 초기화를 해야하는지? -> private final 때문에?? 그렇다면 이걸 왜 사용해야 하는지? -> @Autowired와 비교해보자
     2. 생성자를 만들어두고 컨트롤러 객체를 개발자가 생성한 적은 없는데 그렇다면 누가 컨트롤러 객체를 생성하는 것인지?
     3. ReservationService에서 @Service를 왜 사용해야하는지? -> 스프링빈으로 왜 등록해야 하는지?
     4. @RequiredArgsConstructor은 무엇인지?
     5. ResponseEntity 객체를 사용해야하는가 굳이?
     */

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationCreateResponse> saveReservation(@RequestBody ReservationCreateRequest request) {
        ReservationCreateResponse reservation = reservationService.saveReservation(request);
        return ResponseEntity.ok(reservation);
    }
}
