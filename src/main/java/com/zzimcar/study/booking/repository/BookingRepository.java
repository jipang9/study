package com.zzimcar.study.booking.repository;

import com.zzimcar.study.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
