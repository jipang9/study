package com.zzimcar.study.booking.dto;

import com.zzimcar.study.booking.entity.Booking;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force = true)
public class ReservationRequestDto {

  private String bookerName;
  private String bookerPhoneNumber;
  private String bookerEmail;
  private String bookerPassportName;
  private final List<Booking> bookingList;

}
