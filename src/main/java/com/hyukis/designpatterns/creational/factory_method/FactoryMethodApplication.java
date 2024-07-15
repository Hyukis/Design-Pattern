package com.hyukis.designpatterns.creational.factory_method;

import com.hyukis.designpatterns.creational.global.annotation.DesignPattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FactoryMethodApplication implements ApplicationRunner {

  @Override
  @DesignPattern
  public void run(ApplicationArguments args) throws Exception {
    FactoryClient client = FactoryClient.getInstance();

    client.order(new MacFactory(), "Yuki", "suhyuk.ts@gmail.com");
  }
}
