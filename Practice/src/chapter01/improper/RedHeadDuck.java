package chapter01.improper;

public class RedHeadDuck implements Duck, Quackable {

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
