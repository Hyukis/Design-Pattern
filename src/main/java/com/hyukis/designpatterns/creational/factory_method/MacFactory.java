package com.hyukis.designpatterns.creational.factory_method;

public class MacFactory implements LaptopFactory{

  @Override
  public Laptop make(String consumer, String email) {
    return new Mac(consumer, email);
  }
}
