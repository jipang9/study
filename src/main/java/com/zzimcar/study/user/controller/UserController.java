package com.zzimcar.study.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {


  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

  @GetMapping("/api")
  public String hello2(){
    return "hello2";
  }

  @GetMapping("/api/security")
  public String hello3(){
    return "hello3";
  }
}
