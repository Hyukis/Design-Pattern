package com.hyukis.designpatterns.creational.builder;

import com.hyukis.designpatterns.creational.builder.Plan.PlanType;
import com.hyukis.designpatterns.creational.global.annotation.DesignPattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class BuilderApplication implements ApplicationRunner {

  @Override
  @DesignPattern
  public void run(ApplicationArguments args) throws Exception {
    Plan plan = new Plan.PlanBuilder()
        .planType(PlanType.HEALTH)
        .days(3)
        .title("헬스 계획")
        .amount(300000)
        .build();

    log.info("{}", plan.toString());
  }
}
