package com.zzimcar.study.booking.repository;

import com.zzimcar.study.booking.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
