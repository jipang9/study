package com.zzimcar.study.test;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestRequestDto {


  private String title;
  private List<Sour> sourList;

  public TestEntity toEntity(){
    TestEntity test = TestEntity.builder()
        .title(this.getTitle()).sourList(this.getSourList())
        .build();
    return  test;
  }
}
