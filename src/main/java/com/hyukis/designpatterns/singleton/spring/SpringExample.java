package com.hyukis.designpatterns.singleton.spring;

import com.hyukis.designpatterns.singleton.spring.SpringConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class SpringExample {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

    String instance = applicationContext.getBean("hello", String.class);
    String instance2 = applicationContext.getBean("hello", String.class);

    System.out.println(instance);
    log.info("{}", instance.equals(instance2));
  }

}
