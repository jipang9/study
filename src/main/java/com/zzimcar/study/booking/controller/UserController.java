package com.zzimcar.study.booking.controller;

import com.zzimcar.study.booking.dto.ReservationRequestDto;
import com.zzimcar.study.booking.entity.Reservation;
import com.zzimcar.study.booking.sevice.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

  private final TestService testService;

  @PostMapping("/post")
  public Long post(@RequestBody ReservationRequestDto reservationRequestDto) {
    return testService.postService(reservationRequestDto);
  }

  @GetMapping("/get/{id}")
  public Reservation get(@PathVariable("id")Long id){
    return testService.getService(id);
  }

}

