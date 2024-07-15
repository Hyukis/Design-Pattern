package com.hyukis.designpatterns.creational.factory_method;

public class LGgramFactory implements LaptopFactory{

  @Override
  public Laptop make(String consumer, String email) {
    return new LGgram(consumer, email);
  }
}
