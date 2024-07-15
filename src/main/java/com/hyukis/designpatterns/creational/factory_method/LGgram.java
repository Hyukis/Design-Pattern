package com.hyukis.designpatterns.creational.factory_method;

import lombok.Getter;

@Getter
public class LGgram extends Laptop{

  public LGgram(String consumer, String email) {
    this.OS = "Windows 11";
    this.cpu = "12 Core";
    this.user = consumer;
    this.email = email;
  }
}
