package com.hyukis.designpatterns.factory;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Car {

  private String model;
  private String contractor;
  private String email;
}
