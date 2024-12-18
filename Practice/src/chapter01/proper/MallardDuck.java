package chapter01.proper;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super(
                new FlyNormal(), new QuackNormal()
        );
    }

    @Override
    public void display() {

    }

    @Override
    public void swim() {

    }
}
