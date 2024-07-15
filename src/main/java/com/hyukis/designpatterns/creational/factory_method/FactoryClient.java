package com.hyukis.designpatterns.creational.factory_method;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FactoryClient {

  private static class ClientHelper {
    private static final FactoryClient client = new FactoryClient();
  }

  public static FactoryClient getInstance() {
    return ClientHelper.client;
  }

  protected Laptop order(LaptopFactory laptopFactory, String consumer, String email) {
    Laptop laptop = laptopFactory.order(consumer, email);
    log.info("주문하신 {}이 제작되었습니다.", laptop);

    return laptop;
  }
}
