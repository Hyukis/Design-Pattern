package com.hyukis.designpatterns.factory_method;

public class MacFactory implements LaptopFactory{

  @Override
  public Laptop make(String consumer, String email) {
    return new Mac(consumer, email);
  }
}
