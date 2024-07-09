package com.hyukis.designpatterns.factory.abstracts;

public class MacbookFactory extends LaptopFactory {

  @Override
  protected Laptop createLaptop(String consumer, String email) {
    return new Laptop(Vendor.MAC, consumer, email);
  }
}
