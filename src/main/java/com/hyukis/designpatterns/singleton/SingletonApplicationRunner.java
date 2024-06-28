package com.hyukis.designpatterns.singleton;

import com.hyukis.designpatterns.global.annotation.DesignPattern;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@DesignPattern
public class SingletonApplicationRunner implements ApplicationRunner, Serializable {
  @Override
  @DesignPattern
  public void run(ApplicationArguments args) throws Exception {
    SingletonInstance instance_1 = SingletonInstance.getInstance();
    SingletonInstance instance_2 = SingletonInstance.getInstance();

    log.info("instance_1 hashcode : {}", instance_1.hashCode());
    log.info("instance_2 hashcode : {}", instance_2.hashCode());

    // Singleton destroyed by reflection Singleton Pattern

    Constructor<SingletonInstance> constructor = SingletonInstance.class.getDeclaredConstructor();
    constructor.setAccessible(true);
    SingletonInstance instance_3 = constructor.newInstance();

    log.info("Destroying the Singleton-Pattern using reflection : {}", instance_1 == instance_3);

    // Singleton destroyed by Serialization / Deserialization
    // File to Deserialization 경우 반드시 생성자를 사용해 다시 인스턴스를 만들어준다.
    SingletonInstance instance_4 = SingletonInstance.getInstance();
    SingletonInstance fileInstance  = null;
    try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("./files/settings.obj"))) {
      out.writeObject(instance_4);
    }

    try(ObjectInput in = new ObjectInputStream(new FileInputStream("./files/settings.obj"))) {
      fileInstance = (SingletonInstance) in.readObject();
    }

    log.info("instance_1 hashcode : {}", instance_4.hashCode());
    log.info("instance_2 hashcode : {}", fileInstance.hashCode());
    log.info("Destroying the Singleton-Pattern using Serialization & Deserialization, {}", instance_4 == fileInstance);
  }
}
