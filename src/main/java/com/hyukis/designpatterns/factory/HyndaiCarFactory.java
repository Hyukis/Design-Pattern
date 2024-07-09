package com.hyukis.designpatterns.factory;

public class HyndaiCarFactory implements CarFactory {

  @Override
  public Car createCar(String contractor, String email) {
    return new Car("Hyndai", contractor, email);
  }
}
