package chapter01.proper;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super(
                new FlyNoWay(), new QuackNormal()
        );
    }

    @Override
    public void display() {
        System.out.println("고무오리 보여주기");
    }

    @Override
    public void swim() {
        System.out.println("고무오리 수영하기");
    }
}
