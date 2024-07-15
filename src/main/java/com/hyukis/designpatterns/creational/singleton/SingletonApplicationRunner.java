package com.hyukis.designpatterns.creational.singleton;

import com.hyukis.designpatterns.creational.global.annotation.DesignPattern;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
    SingletonInstance reflection_instance = constructor.newInstance();

    log.info("Destroying the Singleton-Pattern using reflection : {}",
        instance_1 == reflection_instance);

    // Singleton destroyed by Serialization / Deserialization
    // File to Deserialization 경우 반드시 생성자를 사용해 다시 인스턴스를 만들어준다.
    SingletonInstance instance_4 = SingletonInstance.getInstance();
    SingletonInstance fileInstance = null;
    try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/main/resources/files/settings.obj"))) {
      out.writeObject(instance_4);
    }

    try (ObjectInput in = new ObjectInputStream(new FileInputStream("src/main/resources/files/settings.obj"))) {
      fileInstance = (SingletonInstance) in.readObject();
    }

    log.info("instance_4 hashcode : {}", instance_4.hashCode());
    log.info("instance_from_file hashcode : {}", fileInstance.hashCode());
    log.info("Destroying the Singleton-Pattern using Serialization & Deserialization, {}",
        instance_4 == fileInstance);

    // prevent new class-object creation when deserializing from file
    // Definition readResolve() method in SingletonInstance class
    // 보통 Serialization을 상속받으면, readObject() method를 통해 새로운 객체를 생성하나, readResolve()가 정의되어 있으면 기존 객체를 반환하고
    // readObject()를 통해 생성된 객체는 그 즉시 GC에 대상이 된다.
    log.info(
        "Protect the SingletonInstance class that is created through deserialization from a file. {}",
        instance_4 == fileInstance);

    /*
    // Enum Singleton
    SingletonInstanceEnum instance_enum = SingletonInstanceEnum.INSTANCE;

    // Error - Cannot reflectively create enum objects
    SingletonInstanceEnum instance_enum_2 = null;
    Constructor<?>[] declaredConstructors = SingletonInstanceEnum.class.getDeclaredConstructors();
    for (Constructor<?> construct : declaredConstructors) {
      construct.setAccessible(true);
      instance_enum_2 = (SingletonInstanceEnum) construct.newInstance("INSTANCE");
    }

    // Using the enum singleton pattern ensures that the singleton pattern is not broken by reflection.
    log.info("Enum reflection {}",instance_enum == instance_enum_2);
    */


    // An enum class already implements the Serialization interface.

    SingletonInstanceEnum instance_enum = SingletonInstanceEnum.INSTANCE;

    SingletonInstanceEnum instance_enum_2 = null;

    try(ObjectOutput out = new ObjectOutputStream(new FileOutputStream("src/main/resources/files/enum.obj"))) {
      out.writeObject(instance_enum);
    }

    try(ObjectInput in = new ObjectInputStream(new FileInputStream("src/main/resources/files/enum.obj"))){
      instance_enum_2 = (SingletonInstanceEnum) in.readObject();
    }
    log.info("Protect the SingletonInstanceEnum class that is created through deserialization from a file {}",instance_enum == instance_enum_2);
  }
}
