package com.hyukis.designpatterns.factory.abstracts;

import java.util.Arrays;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Vendor {
  SAMSUNG("Windows 10"),
  LG("Windows 10"),
  MAC("Sonoma");

  private String os;

  public static String findOs(Vendor vendor) {
    return Arrays.stream(values())
        .filter(i -> i == vendor)
        .findFirst()
        .map(Vendor::getOs)
        .orElse(null);
  }
}
