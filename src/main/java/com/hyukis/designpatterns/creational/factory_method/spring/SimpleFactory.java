package com.hyukis.designpatterns.creational.factory_method.spring;

import com.hyukis.designpatterns.creational.factory_method.LGgram;
import com.hyukis.designpatterns.creational.factory_method.Laptop;
import com.hyukis.designpatterns.creational.factory_method.Mac;

public class SimpleFactory {

  public Laptop createProduct(String name) {
    Laptop product;
    switch (name){
      case "LGgram" -> product = new LGgram("수혁", "soohyuk96@naver.com");
      case "Mac" -> product = new Mac("수혁", "soohyuk96@naver.com");
      default -> throw new IllegalArgumentException("잘못된 제품명입니다.");
    }
    return product;
  }
}
