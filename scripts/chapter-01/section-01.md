# Chapter 01 - 오리 시뮬레이션과 전략 패턴

---

이번 절에서는 간단한 예시에 디자인 패턴을 적용시켜 `"이렇게 개선할 수 있구나"` 를 보는 section 입니다.

다음과 같은 상황을 생각해봅시다.
우리의 신입사원 `Zoe` 는 오리 시뮬레이션 게임을 만들고 있습니다.
오리는 다양한 행동이 가능한데, `헤엄` 칠 수 있고 `꽥꽥 소리` 도 낼 수 있습니다.

`Zoe` 는 이 요구사항에 맞춰 다음과 같은 코드를 만들었습니다.

```java
interface Duck {
    void quack();
    void swim();
    void display();
}

class MallardDuck implements Duck {/* ... */
}

class RedheadDuck implements Duck {/* ... */
}

class RubberDuck implements Duck {/* ... */
}
/* ... */
```

그런데 어느날 회사 임원진이 `오리가 날 수 있으면 좋겠다` 고 추가 기능을 요구했습니다.

그래서 `Zoe` 는 간단하게 생각해 `Duck` 에 `fly()` 메서드를 추가하였습니다.

```java
interface Duck {
    void quack();
    void swim();
    void display();
    void fly();
}
```

인터페이스에 메서드 하나 추가했는데 뭐 문제가 있겠습니까? 그쵸?

---

## i. 오리 시뮬레이션 삽질

한 시간 뒤, `Zoe` 는 테스트 팀에서 불같은 전화를 받습니다.
무려 `고무 오리` `RubberDuck` 이 날 수 없는데 날아다니고 있다는 전화였습니다.

```java
class RubberDuck implements Duck {

    @Override
    public void fly() {
        System.out.println("까먹고 날 수 있게 설정했네!?");
    }
}
```

`Zoe` 가 `fly()` 메서드를 추가하면서 `RubberDuck` 에 적합하지 않은 행동이 추가된 것이죠.
그래서 `Zoe` 는 `"이왕 망한김에 기능을 제대로 분리해보자"` 라 다짐하며, `오리의 기능을 더 세부적으로 나눠 상속하도록` 리팩터링하였습니다.

```java
interface Duck {
    void swim();
    void display();
}

interface Quackable {
    void quack();
}

interface FlyAble {
    void fly();
}

// 필요에 따라 interface implement
class MallardDuck implements Duck, Quackable, FlyAble {/* ... */
}

class RedheadDuck implements Duck, FlyAble {/* ... */
}

class RubberDuck implements Duck, Quackable {/* ... */
}
```

하지만 불쌍한 `Zoe`, 이번에는 개발 팀장님께 쿠사리를 먹게 됩니다.

고작 `fly()` 메서드 하나로 인한 변경점이 너무 많고, **무엇보다 코드 중복이 너무 많다는 내용이었죠.**

```java
// MallardDuck 에서 구현한 내용이
class MallardDuck
        implements Duck, Quackable, Flyable {

    @Override
    public void quack() {
        System.out.println("꽥");
    }

    @Override
    public void swim() {
        System.out.println("수영수영");
    }

    @Override
    public void display() {
        System.out.println("나는 오리야");
    }

    @Override
    public void fly() {
        System.out.println("날 수 있어");
    }
}

// RedHeadDuck 에서도 똑같이 구현됨
// 코드 중복이 너무 많음!
class RedHeadDuck
        implements Duck, Quackable {

    @Override
    public void quack() {
        System.out.println("꽥");
    }

    @Override
    public void swim() {
        System.out.println("수영수영");
    }

    @Override
    public void display() {
        System.out.println("나는 오리야");
    }
}
```

---

## ii. 문제를 명확하게 파악하기

`Zoe` 는 결국 `상속` 이 그리 성공적인 해결책이 아니라는 것을 알게 되었습니다.
`상속` 으로 오리를 추상적으로 관리할 수 있지만, 팀장님이 말씀하신 `코드 중복` 을 해결할 순 없었기 때문이죠.
~~사실 `default method` 가 있긴 한데 책 집필할 땐 없었나 봅니다~~

위 상황에서 교재는 다음과 같은 원칙을 소개합니다.
> 디자인 원칙
>
> 애플리케이션에서 **`달라지는 부분`** 을 찾아내고, **`달라지지 않는 부분`** 과 분리한다.
>
> `바뀌는 부분` 은 따로 뽑아서 캡슐화한다. 그러면 나중에 바뀌지 않는 부분에는 영향을 미치지 않고 그 부분만 고치거나 확장할 수 있다.

이 개념은 간단하지만 모든 디자인 패턴의 기반을 이루는 원칙입니다. 모든 패턴은 `시스템의 일부분을 다른 부분과 독립적으로 변화시킬 수 있는 방법` 을 제공하기 위해 고안되었기
때문이죠.

이를 앞선 오리 시뮬레이션에 대해 생각해 봅시다.

|     `바뀌지 않았던 부분`      |     `바뀌었던 부분`      |
|:---------------------:|:------------------:|
| `swim()`, `display()` | `quack()`, `fly()` |

오리가 변화했던 과정을 생각해보면 `모든 오리는 헤엄칠 수 있고, display 될 수 있음` 을 알 수 있습니다.
반면 그 종류에 따라 `소리가 바뀌며 날 수 있는지 여부` 가 달라집니다.

---

## iii. 오리 만들기

교재는 위 상황에서 `바뀌었던 부분의 행동을 "위임"` 하는 방법을 제시합니다.

- `quack()` 를 위임

    ```java
    interface QuackBehavior {
        void doQuack();
    }
    
    class QuackNormal implements QuackBehavior {
    
        @Override
        public void doQuack() {
            System.out.println("평범한 꽥꽥");
        }
    }
    
    class MuteQuack implements QuackBehavior {
    
        @Override
        public void doQuack() {
            System.out.println("난 꽥꽥거릴 수 없어..");
        }
    }
    ```

- `fly()` 를 위임

    ```java
    interface FlyingBehavior {
        void doFly();
    }
    
    class FlyNormal implements FlyingBehavior {
    
        @Override
        public void doFly() {
            System.out.println("평범하게 날기");
        }
    }
    
    class FlyNoWay implements FlyingBehavior {
    
        @Override
        public void doFly() {
            System.out.println("난 날수 없어..");
        }
    }
    ```

- `Duck` 을 구현

  ```java
  abstract class Duck {
    abstract public void display();
    abstract public void swim();
  
    private final FlyingBehavior flyBehavior;
    private final QuackBehavior quackBehavior;
  
    public Duck(FlyingBehavior flyBehavior, QuackBehavior quackBehavior) {
      this.flyBehavior = flyBehavior;
      this.quackBehavior = quackBehavior;
    }
  
    public void quack() {
      quackBehavior.doQuack();  }
  
    public void fly() {
      flyBehavior.doFly();  }
  }
  ```
  ```java
  class MallardDuck extends Duck {
  
    public MallardDuck() {
      super(
              new FlyNormal(), new QuackNormal()
      );
    }
  
    @Override
    public void display() {}
    @Override
    public void swim() {}
  }
  
  class RubberDuck extends Duck {
  
    public RubberDuck() {
      super(
              new FlyNoWay(), new QuackNormal()
      );
    }
  
    @Override
    public void display() {}
    @Override
    public void swim() {}
  }
  ```

위 소스코드의 `Duck` 을 보면 `FlyingBehavior`, `QuackBehavior` 을 이용해 `quack()`, `fly()` 의 행동을 `위임` 하고 있음을 볼 수
있습니다.
이처럼 만들 경우, **어떠한 `quack`, `fly` 가 요구되든 `Duck` 은 변경하지 않으면서 기능을 확장**할 수 있습니다.

---

## iv. 캡슐화된 행동 살펴보기

위처럼 `행동을 위임` 하는 것은 `행동을 캡슐화` 하는 것이라 볼 수 있습니다.
오리의 행동을 `"일련의 행동"` 으로 생각하는 대신 `"행동의 집합"` 으로 생각하는 것이죠.

이는 이전에 갇혀있던 `상속` 의 제한에서 벗어나, 더 `재사용 하기 쉬운` 길을 보여줍니다.

> 디자인 원칙
>
> 상속보다는 구성을 활용한다.

```java
interface Duck {
  void swim();
  void display();
}

interface Quackable {
  void quack();
}

interface FlyAble {
  void fly();
}

class RubberDuck implements Duck, Quackable {/* ... */}
```

```java
abstract class Duck {
  abstract public void display();
  abstract public void swim();

  // 구성 (composition)
  private final FlyingBehavior flyBehavior;
  private final QuackBehavior quackBehavior;

  public Duck(FlyingBehavior flyBehavior, QuackBehavior quackBehavior) {
    this.flyBehavior = flyBehavior;
    this.quackBehavior = quackBehavior;
  }

  public void quack() {
    quackBehavior.doQuack();  }

  public void fly() {
    flyBehavior.doFly();  }
}
```

교재는 이를 디자인 패턴의 중요한 테크닉이자 원칙으로 소개하고 있습니다. `상속` 보다 더 좋은 방향이 있을 수 있다는 것이지요.

---

## v. 첫 번째 디자인 패턴 : 전략 패턴

앞서 `오리` 예시에 적용된 디자인 패턴이 `전략 패턴` 입니다.

> ### 전략 패턴 : _Strategy Pattern_
>
> 전략 패턴은 알고리즘군 `(Family of algorithms)` 을 정의하고 캡슐화해 각각의 알고리즘군을 수정할 수 있는 패턴입니다.
>
> 전략 패턴을 이용하면 `개체의 행동` 이 분리해 독립적으로 관리할 수 있습니다.

교재는 위 예시를 통해 단순히 `객체 지향 디자인 원칙` 을 지킨다고 `휼륭한 객체지향` 코드가 만들어지지 않음을 강조합니다.
`디자인 패턴` 이 `객체 지향 원칙` 에 기초한 것은 맞지만 그 이상의 무언가가 더 필요하다는 것입니다.

결국 `디자인 패턴` 은 `유연하고, 재사용이 용이하고, 관리하기 쉬운 시스템` 을 만들기 위한 방범론 입니다.
즉, 어떤 방법을 보여주는 것이지 `만능 정답지` 가 아니라는 뜻입니다.

교재도 이를 시사하며 결국 중요한 것은 `상황에 맞는 코드` 임을 강조합니다.

---
