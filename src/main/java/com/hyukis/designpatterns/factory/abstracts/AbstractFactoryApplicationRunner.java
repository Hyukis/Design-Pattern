package com.hyukis.designpatterns.factory.abstracts;

import com.hyukis.designpatterns.global.annotation.DesignPattern;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AbstractFactoryApplicationRunner implements ApplicationRunner {

  @Override
  @DesignPattern
  public void run(ApplicationArguments args) throws Exception {
    Client client = new Client();

    client.laptopOrder(new MacbookFactory(), "엄수혁", "soohyuk96@naver.com");
    log.info("--------------------------------------------------------------------");
    client.laptopOrder(new LgGramFactory(), "엄수혁", "soohyuk96@naver.com");

  }

  public static class Client {

    public void laptopOrder(LaptopFactory laptopFactory, String consumer, String email) {
      log.info("{}", laptopFactory.orderLaptop(consumer, email));
    }
  }
}
