package com.hyukis.designpatterns.factory.abstracts;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
@EqualsAndHashCode
@AllArgsConstructor
public class Laptop {

  private Vendor vendor;
  private String consumer;
  private String email;
}
