package com.hyukis.designpatterns.creational.factory_method.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

  @Bean("hello_simple")
  @Qualifier("hello_simple")
  public String helloSimple() {
    return "hello, Simple Configuration";
  }
}
