package com.hyukis.designpatterns.factory.abstracts;

public class LgGramFactory extends LaptopFactory{

  @Override
  protected Laptop createLaptop(String consumer, String email) {
    return new Laptop(Vendor.LG, consumer, email);
  }
}
