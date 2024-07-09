# 📝 Quiz

## 싱글톤 패턴 (Singleton Pattern)
> 공통으로 사용되는 객체를 하나의 객체로 사용하기 위한 패턴이다.
1. 자바에서 enum을 사용하지 않고, 구현할 수 있는 Singleton 방법은?
   1. Eager
   2. Lazy
   3. synchronized / volatile (DCL)
   4. static block
   5. Bill Pugh 방식


2. private 생성자 static 메소드를 사용하는 방법의 단점은?
    1. 클래스 로더에 의해 서버가 부팅될 때 즉시 로딩되기 때문에, 실제 사용되지 않아도 메모리를 차지하게 된다.


3. Enum을 사용해 싱글톤 패턴을 구현하는 방법의 장점과 단점은?
   1. (장점) 보틍은 Reflection 또는 Serialization / Deserialization을 통해 싱글톤 패턴을 부술 수 있지만, Enum 클래스는 이를 막아놔 안전한다.
   2. (단점) 테스트 하기가 상당히 어렵다.


4. static inner class를 활용하여 싱글톤을 구현한라.
~~~java
// 3가지의 경우의 수
public class Singleton {

  // 1번째 방법
  private static final Singleton instance = new Singleton();

  private Singleton() {
  }

  public static Singleton getInstance() {
    return this.instance;
  }
}

public class Singleton {
  // 2번째 방법 (Method Synchronized / DCL)
  private static Singleton instance;
  
  private Singleton() {}
  
  public static /*synchronized*/ Singleton getInstance(){
    if(instance2 = null ) {
      synchronized (Singleton.class) {
        if(instance2 == null) {
          instance2 = new Singleton();
        }
      }
    }
    return this.instance;
  }
}

public class Singleton {
  
  private static class SingletonHelper {
    private static final Singleton INSTANCE = new Singleton();
  }
  
  public static Singleton getInstance() {
    return SingletonHelper.INSTANCE;
  }
}
~~~
