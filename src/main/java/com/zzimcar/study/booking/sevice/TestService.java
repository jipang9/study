package com.zzimcar.study.booking.sevice;

import com.zzimcar.study.booking.dto.ReservationRequestDto;
import com.zzimcar.study.booking.entity.Reservation;
import com.zzimcar.study.booking.repository.BookingRepository;
import com.zzimcar.study.booking.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {

  private final ReservationRepository reservationRepository;

  @Transactional
  public Long postService(ReservationRequestDto reservationRequestDto) {
    Reservation reservation = new Reservation(reservationRequestDto.getBookerName(),
        reservationRequestDto.getBookerPhoneNumber(),
        reservationRequestDto.getBookerEmail(), reservationRequestDto.getBookerPassportName(),
        reservationRequestDto.getBookingList());
    reservationRepository.save(reservation);
    return reservation.getId();
  }

  @Transactional(readOnly = true)
  public Reservation getService(Long id) {
    final Reservation reservation = reservationRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("데이터 존재 x"));
    return reservation;
  }
}


