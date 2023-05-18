package com.zzimcar.study.booking.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String bookerName;

  @Column(nullable = false)
  private String bookerPhoneNumber;

  @Column(nullable = false)
  private String bookerEmail;

  @Column(nullable = false)
  private String bookerPassportName;

  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Booking> bookingList = new ArrayList<>();

  public Reservation(String bookerName, String bookerPhoneNumber, String bookerEmail,
      String bookerPassportName, List<Booking> bookingList) {
    this.bookerName = bookerName;
    this.bookerPhoneNumber = bookerPhoneNumber;
    this.bookerEmail = bookerEmail;
    this.bookerPassportName = bookerPassportName;
    this.bookingList = bookingList;
  }

}
