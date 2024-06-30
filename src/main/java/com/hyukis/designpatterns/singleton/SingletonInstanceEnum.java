package com.hyukis.designpatterns.singleton;

// enum은 기본적으로 Serialization을 상속받고 있다.
public enum SingletonInstanceEnum {

  INSTANCE;

  SingletonInstanceEnum() {
  }
}

