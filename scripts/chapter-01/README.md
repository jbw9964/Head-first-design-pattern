---

> # 디자인 패턴 소개와 전략 패턴
>
> 디자인 패턴의 세계로 떠나기

---

## Section

- [`[1] : 오리 시뮬레이션과 전략 패턴`](./section-01.md)
    - [`i. 오리 시뮬레이션 삽질`](./section-01.md#i-오리-시뮬레이션-삽질)
    - [`ii. 문제를 명확하게 파악하기`](./section-01.md#ii-문제를-명확하게-파악하기)
    - [`iii. 오리 만들기`](./section-01.md#iii-오리-만들기)
    - [`iv. 캡슐화된 행동 살펴보기`](./section-01.md#iv-캡슐화된-행동-살펴보기)
    - [`v. 첫 번째 디자인 패턴 : 전략 패턴`](./section-01.md#v-첫-번째-디자인-패턴--전략-패턴)

---

## Summary

> ### 디자인 원칙
>
> 1. 애플리케이션에서 `달라지는 부분` 을 찾아내고, `달라지지 않는 부분` 과 분리한다.
> 2. 구현보다 인터페이스에 맞춰서 프로그래밍 한다.
> 3. 상속보다는 구성을 활용한다.

이번 챕터는 `디자인 패턴이 왜 중요한가`, `단순 객체지향과 무엇이 다른가` 를 나타내는 챕터였습니다.

분명히 `디자인 패턴` 은 `객체지향 디자인 원칙` 에 기반했지만, 단순히 `객체지향 디자인` 을 지키는 것 만으로는 부족하다고 합니다.

교재는 이를 `오리 시뮬레이션` 예시를 통해 보여줍니다.
`오리 시뮬레이션` 은 단순 `상속`, `다형성` 만으로는 **유연하고 재사용이 가능한, 관리하기 쉬운 시스템**을 만들기 어려움을 보여줍니다.

> ### 전략 패턴 : _Strategy Pattern_
>
> 전략 패턴은 알고리즘군 `(Family of algorithms)` 을 정의하고 캡슐화해 각각의 알고리즘군을 수정할 수 있는 패턴입니다.
>
> 전략 패턴을 이용하면 `개체의 행동` 이 분리해 독립적으로 관리할 수 있습니다.

<details><summary> 전략 패턴 예시</summary>

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

class RubberDuck implements Duck, Quackable {/* ... */
}
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
        quackBehavior.doQuack();
    }

    public void fly() {
        flyBehavior.doFly();
    }
}
```

</details>

`전략 패턴` 은 `특정 작업` 을 다양한 방식으로 수행하는 `전략` 들로 분리해, `전략을 교체` 함으로서 유연성을 높이는 디자인 패턴입니다. [`[1]`](#reference)

```java
interface Strategy {

    void doSomething();
}

class DoNormal implements Strategy {

}

class DoRandom implements Strategy {

}

class DoNothing implements Strategy {

}

class Something {

    Strategy strategy;

    public void doSomething() {
        strategy.doSomething();
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
```

위처럼 구성 시 클래스 `Something` 의 입장에선 `doSomething()` 은 어떤 `Strategy` 든 동일하게 수행할 수 있으며, `runtime`
시에도 `Something#doSomething` 을 자유롭게 바꿀 수 있습니다.

```java
Something some = new Something();

// DoNormal 의 행동 수행
some.

setStrategy(new DoNormal());
        some.

doSomething();

// DoNothing 의 행동 수행
some.

setStrategy(new DoNothing());
        some.

doSomething();
```

---

## Reference

- [`[1] : Strategy Pattern - Refactoring GURU`](https://refactoring.guru/design-patterns/strategy)
