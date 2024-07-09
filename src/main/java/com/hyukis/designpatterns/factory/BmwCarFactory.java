package com.hyukis.designpatterns.factory;



public class BmwCarFactory implements CarFactory {

  @Override
  public Car createCar(String contractor, String email) {
    return new Car("BMW", contractor, email);
  }
}
