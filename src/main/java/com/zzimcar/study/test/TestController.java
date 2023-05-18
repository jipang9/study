package com.zzimcar.study.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

  private final SourTestService testService;

  @PostMapping("/post/sour")
  public void postTest(@RequestBody TestRequestDto testRequestDto){
    testService.postTest(testRequestDto);
  }

  @GetMapping("/get/test/{id}")
  public TestEntity getTest(@PathVariable("id")Long id){
    return testService.getTest(id);
  }

}
