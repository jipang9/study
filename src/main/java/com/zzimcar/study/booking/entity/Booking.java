package com.zzimcar.study.booking.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Booking extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "personnel_id")
  private Personnel personnel;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "rentDate_id")
  private RentDate rentDate;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "location_id")
  private Location location;

  public Booking(Personnel personnel, RentDate rentDate, Location location) {
    this.personnel = personnel;
    this.rentDate = rentDate;
    this.location = location;
  }

}
