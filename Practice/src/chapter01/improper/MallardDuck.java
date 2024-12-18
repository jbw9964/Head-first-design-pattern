package chapter01.improper;

public class MallardDuck implements Duck, Quackable, Flyable {

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
