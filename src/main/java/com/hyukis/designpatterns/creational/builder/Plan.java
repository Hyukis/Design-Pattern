package com.hyukis.designpatterns.creational.builder;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Plan {

  private PlanType planType;
  private String title;
  private int days;
  private int amount;

  public static enum PlanType {
    TOUR, WORK, HEALTH;
  }

  public static class PlanBuilder {

    private PlanType planType;
    private String title;
    private int days;
    private int amount;

    public PlanBuilder title(String title) {
      this.title = title;
      return this;
    }

    public PlanBuilder days(int days) {
      this.days = days;
      return this;
    }

    public PlanBuilder amount(int amount) {
      this.amount = amount;
      return this;
    }

    public PlanBuilder planType(PlanType planType) {
      this.planType = planType;
      return this;
    }

    public Plan build() {
      return new Plan(this.planType, this.title, this.days, this.amount);
    }
  }
}
