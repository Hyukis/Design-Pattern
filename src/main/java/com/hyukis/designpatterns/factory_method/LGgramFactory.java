package com.hyukis.designpatterns.factory_method;

public class LGgramFactory implements LaptopFactory{

  @Override
  public Laptop make(String consumer, String email) {
    return new LGgram(consumer, email);
  }
}
