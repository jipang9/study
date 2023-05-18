package com.zzimcar.study.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SourTestService {

  private final TestRepository testRepository;

  @Transactional
  public void postTest(TestRequestDto testRequestDto) {
    final TestEntity test = testRequestDto.toEntity();
    testRepository.save(test);
  }

  public TestEntity getTest(Long id){
    final TestEntity test = testRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("오류입니다"));
    return test;
  }
}
