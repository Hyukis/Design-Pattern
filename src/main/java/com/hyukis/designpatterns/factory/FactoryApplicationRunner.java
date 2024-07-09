package com.hyukis.designpatterns.factory;

import com.hyukis.designpatterns.global.annotation.DesignPattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FactoryApplicationRunner implements ApplicationRunner {

  @Override
  @DesignPattern
  public void run(ApplicationArguments args) throws Exception {


    Car bmw = getCar(new BmwCarFactory(), "엄수혁", "soohyuk96@naver.com");
    log.info("{}", bmw);
    log.info("--------------------------------------------------------------------");
    Car hyndai = getCar(new HyndaiCarFactory(), "정하윤", "hayoon0326@naver.com");
    log.info("{}", hyndai);
  }

  private Car getCar(CarFactory factory, String contractor, String email) {
    return factory.orderCar(contractor, email);
  }
}
