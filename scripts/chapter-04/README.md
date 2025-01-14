
# Chapter 04 - 객체지향 빵 굽기 : 팩토리 패턴

## Summary

교재는 `팩토리 패턴` 이 무엇인지 설명한다.

> ### 팩토리 패턴 : _Factory Pattern_
>
> 팩토리 패턴은 `객체의 생성` 을 다른 누군가에게 위임하는 패턴이다.
>
> 이는 어찌보면 `전략 패턴` 과 동일하다 생각할 수 있는데, `전략 패턴` 은 `개체의 동작` `(operation)` 에 집중한 반면 팩토리 패턴은 `개체의 생성` `(creation)` 에 집중했다 볼 수 있다.

이는 결합도를 낮추는 `목적` 에 따라 `팩토리 메서드 패턴` 과 `추상 팩토리 패턴` 으로 나눌 수 있다.

> ### 팩토리 메서드 패턴 : _Factory Method Pattern_
> 
> `"단일 Product"` 의 결합도를 낮추기 위한 팩토리 패턴.
> 
> 간략히 요약해 `factory` 에 한 `product` 를 생성하는 구조.

> ### 추상 팩토리 패턴 : _Abstract Factory Pattern_
> 
> `"Product 집단"` 또는 `ConcreteFactory` 의 결합도를 낮추기 위한 팩토리 패턴.
> 
> 간략히 요약해 한 `factory` 에 여러개의 `product` 를 생성하는 구조.

이 둘은 `객체 생성을 위임` 한다는 점에서 동일하다. 하지만 결합도를 낮추는 `주체` 가 다르다. 한번 예시를 통해 차이를 확인하자.

일단 기본 전제로 아래의 클래스 `(product)` 가 존재한다 생각하자.

```java
interface Product {}

class ProductA_1 implements Product {}
class ProductA_2 implements Product {}

/* ... B & C ... */
```

- Factory Method

    팩토리 메서드 패턴은 `각 패토리별 단 하나의 제품을 생성` 함에 목적이 있다.

    ```java
    // Factory
    
    abstract class Factory {
    
        protected Product createProduct(
                Supplier<Product> type1, 
                Supplier<Product> type2
        ) {
            return new Random().nextBoolean() ?
                    type1.get() : type2.get();
        }
    
        public abstract Product createProduct();
    }
    
    class FactoryA extends Factory {
    
        @Override
        public Product createProduct()  {
            return this.createProduct(
                    ProductA_1::new, ProductA_2::new
            );
        }
    }
    ```
    
    ```java
    // Client
    
    FactoryA factoryA = new FactoryA();
    FactoryB factoryB = new FactoryB();
    FactoryC factoryC = new FactoryC();
    
    // 팩토리별 단 하나의 제품을 생성
    System.out.println(factoryA.createProduct());
    System.out.println(factoryB.createProduct());
    System.out.println(factoryC.createProduct());
    
    // 팩토리에서 생성되는 제품들은 서로 "연관" 된 부분이 없음.
    // 이들을 "묵어서 관리" 하고 싶다면 추상 팩토리 패턴을 사용.
    ```

- Abstract Factory

    반면 추상 팩토리 패턴은 팩토리 메서드 패턴과 달리 `해당 팩토리에 연관된 제품군을 생성` 함에 목적이 있다.
    
    즉, 메서드 패턴은 단일 제품을 생성함에, 추상 팩토리 패턴은 여러개의 제품을 묶어서 생성함에 목적이 있는 것이다.
    
    ```java
    // Factory
    
    abstract class AbstractFactory {
    
        public abstract List<Product> createProductGroup();
    }
    
    class FactoryType1 extends AbstractFactory {
    
        @Override
        public List<Product> createProductGroup() {
            return List.of(
                    new ProductA_1(), new ProductB_1(), new ProductC_1()
            );
        }
    }
    ```


사실 개인적으로 두 패턴을 왜 분리해 생각하는지 잘 모르겠다.

물론 추상 팩토리 패턴은 `상속 없이 제품군을 묶어 관리` 할 수 있어 매우 유용하게 느껴진다.

하지만 메서드 패턴은 도저히 왜 존재하는지 이해되지 않는다. 메서드 패턴은 `단일 제품` 을 생성하고 추상 팩토리 패턴은 `제품군` 을 생성하므로 `메서드 패턴은 추상 팩토리 패턴의 부분집합` 으로만 느껴지기 때문이다.

나중에 더 잘 알게되면 보충해야 할 듯 싶다.

> ### 디자인 원칙
> 
> 1. 추상화된 것에 의존하게 만들고 구상 클래스에 의존하지 않게 만든다. _(DIP)_ 

---