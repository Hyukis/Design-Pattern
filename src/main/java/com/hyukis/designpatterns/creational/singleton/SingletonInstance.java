package com.hyukis.designpatterns.creational.singleton;

/*
 * 1. Eager Initialization
 * > 클래스의 인스턴스 클래스를 로딩 단계에서 즉시 생성
 * 2. Lazy Initialization
 * > 객체가 최초로 사용되는 시점에 로드한다.
 * 3. Static Block Initialization
 * > Eager Initialization과 유사하나, static block을 통해서 execption handle이 가능하다.
 * 4. Thread Safe Singleton
 * > 메소드를 synchronized 키워드를 사용하여 Thread-Safe 하지만 속도적으로 느림
 * 4-1. Thread Safe Double Check Initialization
 * > 4번 방법을 해결하기 위해 synchronized 블록을 활용한 더블 체킹
 * > DCL(Double Checking Lock)을 통한 속력 향상 및 volatile(볼레틸) 키워드를 함께 사용해야한다.
 * 5. Bill Pugh Singleton Implementation
 * */

import java.io.Serializable;

public class SingletonInstance implements Serializable {

  // 1. Eager Initialization
  /*private static SingletonInstance instance;

  private SingletonInstance() {}

  public static SingletonInstance getInstance() {
    if(instance == null) {
      instance = new SingletonInstance();
    }
    return instance;
  }*/

  // 2. Lazy Initialization
  /*private static final SingletonInstance INSTANCE = new SingletonInstance();

  private SingletonInstance() {}

  public static SingletonInstance getInstance() {
    return instance;
  }*/

  // 3. Static Block Initialization
  /*private static SingletonInstance instance;

  private SingletonInstance() {}

  static {
    try {
      instance = new SingletonInstance();
    } catch(Exception ex) {
      throw new RuntimeException("Exception occurred in creating singleton instance");
    }
  }

  public static SingletonInstance getInstance() {
    return instance;
  }*/

  // 4. Thread Safe Initialization (synchronized)
  /*private static SingletonInstance instance;

  private SingletonInstance() {
  }

  public static synchronized SingletonInstance getInstance() {
    if (instance == null) {
      instance = new SingletonInstance();
    }
    return instance;
  }*/

  // 4-1. Thread Safe & Upgrade Limit
  /*private static volatile SingletonInstance instance;

  private SingletonInstance() {
  }

  public static SingletonInstance getInstance() {

    if (instance == null) {
      synchronized (SingletonInstance.class) {
        if (instance == null) {
          instance = new SingletonInstance();
        }
      }
    }
    return instance;
  }*/

  // 5. Bill Pugh Singleton Implementation
  private SingletonInstance() {}

  private static class SingletonHelper {
    private static final SingletonInstance INSTANCE = new SingletonInstance();
  }

  public static SingletonInstance getInstance() {
    return SingletonHelper.INSTANCE;
  }

  // countermeasure of Deserialization
  protected Object readResolve() {
    return getInstance();
  }
}
