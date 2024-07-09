package com.hyukis.designpatterns.factory.abstracts;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class LaptopFactory {

  protected abstract Laptop createLaptop(String consumer, String email);

  public Laptop orderLaptop(String consumer, String email) {
    Laptop laptop = createLaptop(consumer, email);
    installOS(laptop.getVendor());
    setting(laptop);
    sendToMail(laptop.getEmail());

    return laptop;
  }

  private void installOS(Vendor vendor) {
    String os = Vendor.findOs(vendor);
    log.info("{} 운영체제 설치가 완료되었습니다", os);
  }

  private void setting(Laptop laptop) {
    log.info("사용자명 {}, 이메일 {} 로 사용자 정보를 초기화하였습니다.", laptop.getConsumer(), laptop.getEmail());
  }

  private void sendToMail(String email) {
    log.info("{}로 사용 방법에 대한 안내서를 보내드렸습니다.", email);
  }
}
