package com.hyukis.designpatterns.global.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class DesignPatternAspect {

  @Around("@annotation(com.hyukis.designpatterns.global.annotation.DesignPattern)")
  public Object getApplicationNameWithTimer(ProceedingJoinPoint joinPoint) throws Throwable {
    log.info("");
    log.info("============================================================");
    log.info("============= {} =============", joinPoint.getSignature().toShortString());
    log.info("============================================================");
    long start = System.currentTimeMillis();
    Object proceed = joinPoint.proceed();
    long end = System.currentTimeMillis();
    log.info("============================================================");
    log.info(joinPoint.getSignature().toShortString() + " end time : " + (end - start) + "ms");
    log.info("============================================================");
    log.info("");
    return proceed;
  }
}
