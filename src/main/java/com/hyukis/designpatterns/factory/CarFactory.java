package com.hyukis.designpatterns.factory;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface CarFactory {
  Logger log = Logger.getLogger(CarFactory.class.getName());

  Car createCar(String contractor, String email);

  default Car orderCar(String contractor, String email) {
    validate(contractor, email);
    prepare(contractor);
    Car car = createCar(contractor, email);
    sendEmailTo(contractor, car);
    return car;
  }

  private void sendEmailTo(String contractor, Car car){
    log.log(Level.INFO,"{0}님께서 주문하신 {1} 차량이 생산되어 출고 정보는 {2}로 연락드립니다.", new Object[] {contractor, car.getModel(), car.getEmail()});
  }

  private void validate(String contractor, String email) {
    if(contractor.isBlank()) {
      throw new NullPointerException("contractor 필수 항목입니다.");
    }

    if(email.isBlank()) {
      throw new NullPointerException("email 필수 항목입니다.");
    }
  }

  private void prepare(String contractor) {
    log.log(Level.INFO, "{0}님이 요청하신 차량을 만들 준비중입니다.", contractor);
  }
}
