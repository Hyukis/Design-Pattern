package com.hyukis.designpatterns.creational.factory_method;

import java.util.logging.Level;
import java.util.logging.Logger;

public interface LaptopFactory {

  Logger log = Logger.getLogger(LaptopFactory.class.getName());

  Laptop make(String consumer, String email);

  default Laptop order(String consumer, String email) {
    ready(consumer, email);
    Laptop product = make(consumer, email);
    complete(consumer, email);

    return product;
  }

  private void ready(String consumer, String email) {
    log.log(Level.INFO, "[{0}] {1}님이 주문하신 노트북이 주문 제작 준비를 완료했습니다.", new String[] {email, consumer});
  }

  private void complete(String consumer, String email) {
    log.log(Level.INFO, "[{0}] {1}님이 주문하신 노트북이 주문 제작을 완료했습니다.", new String[] {email, consumer});
  }
}
