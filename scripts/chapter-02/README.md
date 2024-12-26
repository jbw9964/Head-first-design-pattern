# Chapter 02 - 객체들에게 연락 돌리기 : 옵저버 패턴

## Summary

이번 챕터는 `Observer` 패턴을 연습하는 챕터이다.

그런데 보면 볼수록 `Observer` 패턴은 `Strategy` 패턴의 일종인 것 같은 느낌이 든다.

`Observer`, `Strategy` 모두 행동하게 되는 주체가 `"SupElements"` 들 이기 때문이다.

그래서 내가 느끼기에 `Observer` 패턴은 `"Callback 설정된 복수의 Strategy 패턴"` 이라 느껴진다.

`Observer` 패턴은 간단히 말해 `Subject 가 Observer 들의 행동을 callback` 하는 형태로, 아래의 코드와 같다.

- interface 를 통한 간단한 추상화

    ```java
    interface Subject {
    
      void registerObserver(Observer o);
      void notifyToObservers();
    }
    
    interface Observer {
      void update();
    }
    ```

- `"딱딱한"` `(Concrete)` 구현체들

  ```java
  import java.util.*;
  
  class TestSubject implements Subject {
  
      private final List<Observer> observers;
  
      public TestSubject() {
          this.observers = new ArrayList<>();
      }
  
      @Override
      public void registerObserver(Observer o) {
          this.observers.add(o);
      }
  
      @Override
      public void notifyToObservers(boolean push) {
          this.observers
                .forEach(Observer::update);
      }
  }
  
  class TestObserver implements Observer {
  
      private Subject subject;
  
      public TestObserver(Subject subject) {
          this.subject = subject;
          subject.registerObserver(this);
      }
  
      @Override
      public void udpate() {
          /* ... */
      }
  }
  ```

이 때 `Observer` 가 행동하는 방식은 크게 2 가지로 나뉘는데, `Push` 방식과 `Pull` 방식이다.

```java

class TestSubject implements Subject {

    private int dataX, dataY, dataZ;

    /* ... */

    @Override
    public void notifyToObservers(boolean push) {

        observers.forEach(push ?

                // push 방식
                o -> o.update(dataX, dataY, dataZ) :

                // pull 방식
                Observer::update
        )
    }
}

class TestObserver implements Observer {

    private TestSubject subject;

    /**
     * {@code Push} 방식의 {@code update}
     */
    @Override
    public void update(int dataX, int dataY, int dataZ) {
        /* ... do something ... */
    }

    /**
     * {@code Pull} 방식의 {@code update}
     */
    @Override
    public void update() {
        int dataX = subject.getDataX();
        int dataY = subject.getDataY();
        int dataZ = subject.getDataZ();

        /* ... do something ... */
    }
}
```

위 `TestObserver#update` 메서드를 보면 `Push`, `Pull` 방식의 차이점을 알 수 있다.

`Push` 방식은 `"Observer 가 행동하기 위한 무언가를 Subject 에서 주입"` 하는 방식으로, `update( ... )` 로 메서드가 선언되어 있다.

반면 `Pull` 방식은 `"Observer 가 행동하기 위한 무언가를 Observer 에서 가져오는"` 방식으로, `udpate()` 메서드 속 `subject` 의 정보를
필요에 따라 가져오는 것을 볼 수 있다.

개인적으로 `Push` 방식보다 `Pull` 방식이 훨씬 유연해 좋아 보인다.

> ### 디자인 원칙
>
> 1. 상호작용하는 객체 사이에는 가능하면 느슨한 결합을 사용해야 한다.

> ### 옵저버 패턴 : _Observer Pattern_
>
> 옵저버 패턴은 한 객체의 상태가 바뀌면 그 객체에 의존하는 다른 객체들이 갱신되는 _one-to-many_ 의존성을 정의합니다.

---

## Reference

---