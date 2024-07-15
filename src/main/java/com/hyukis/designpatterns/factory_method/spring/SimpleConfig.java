package com.hyukis.designpatterns.factory_method.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SimpleConfig {

  @Bean
  public String hello() {
    return "hello, Simple Configuration";
  }
}
