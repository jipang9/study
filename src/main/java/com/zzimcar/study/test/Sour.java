package com.zzimcar.study.test;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Sour {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String aaa;
  private String bbb;

  @ManyToOne(fetch = FetchType.LAZY)
  private TestEntity testEntity;

  @OneToOne(cascade = CascadeType.ALL)
  private Spicy spicy;

}
