package com.hyukis.designpatterns.creational.factory_method;

import lombok.Getter;

@Getter
public class Mac extends Laptop {

  public Mac(String consumer, String email) {
    this.OS = "Sonama";
    this.cpu = "16 Core";
    this.user = consumer;
    this.email = email;
  }
}
