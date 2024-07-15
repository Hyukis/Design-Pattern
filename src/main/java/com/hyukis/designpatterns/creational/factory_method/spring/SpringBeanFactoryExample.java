package com.hyukis.designpatterns.creational.factory_method.spring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBeanFactoryExample {

  public static void main(String[] args) {
    BeanFactory xmlFactory = new ClassPathXmlApplicationContext("custom-bean.xml");
    String xml_hello = xmlFactory.getBean("hello_xml", String.class);
    System.out.println(xml_hello);

    BeanFactory javaFactory = new AnnotationConfigApplicationContext(SimpleConfig.class);
    String config_hello = javaFactory.getBean("hello_simple", String.class);
    System.out.println(config_hello);
  }
}
