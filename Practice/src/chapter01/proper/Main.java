package chapter01.proper;

public class Main {

    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        mallard.quack();
        mallard.fly();

        Duck rubber = new RubberDuck();
        rubber.quack();
        rubber.fly();
    }
}
