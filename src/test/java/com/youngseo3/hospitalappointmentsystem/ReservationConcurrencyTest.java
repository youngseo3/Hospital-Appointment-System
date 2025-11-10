package com.youngseo3.hospitalappointmentsystem;

import com.youngseo3.hospitalappointmentsystem.entity.Reservation;
import com.youngseo3.hospitalappointmentsystem.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ReservationConcurrencyTest {

    @Autowired
    private ReservationRepository reservationRepository;
    private List<Reservation> savedReservations;
    private static final int THREAD_COUNT = 100;

    @BeforeEach
    void 각각의_테스트를_하기_전에_THREAD_COUNT만큼_쓰레드가_동시에_예약한다() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(THREAD_COUNT);
        LocalDate baseDate = LocalDate.of(2025, 11, 10);

        for (int i = 1; i <= THREAD_COUNT; i++) {
            int thread = i;
            executorService.submit(() -> {
                try {
                    int dayOffset = thread / 9;
                    int hourOffset = thread % 9;

                    Long doctorId = 1L;
                    LocalDateTime reservationTime = LocalDateTime.of(
                            baseDate.plusDays(dayOffset),
                            LocalTime.of(9 + hourOffset, 0)
                    );

                    Reservation reservation = new Reservation(
                            (long) (thread % THREAD_COUNT),
                            doctorId,
                            reservationTime,
                            "증상 " + thread
                    );

                    reservationRepository.save(reservation);
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();
        executorService.shutdown();

        // 저장된 예약 조회
        savedReservations = reservationRepository.findAll();
    }

    @Test
    void 예약은_THREAD_COUNT_만큼_모두_저장되어야_한다() {
        assertThat(savedReservations).hasSize(THREAD_COUNT);
    }

    @Test
    void 예약_생성_시_id_중복이_발생하지_않아야_한다() {
        Set<Long> ids = savedReservations.stream()
                .map(Reservation::getId)
                .collect(Collectors.toSet());

        assertThat(ids).hasSize(THREAD_COUNT);
    }

    @Test
    void ID는_1씩_순차적으로_증가해야_한다() {
        List<Long> sortedIds = savedReservations.stream()
                .map(Reservation::getId)
                .sorted()
                .toList();

        for (int i = 0; i < THREAD_COUNT; i++) {
            assertThat(sortedIds.get(i)).isEqualTo((long) (i + 1));
        }
    }
}