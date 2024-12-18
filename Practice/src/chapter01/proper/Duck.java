package chapter01.proper;

public abstract class Duck {

    abstract public void display();

    abstract public void swim();

    private final FlyingBehavior flyBehavior;
    private final QuackBehavior quackBehavior;

    public Duck(FlyingBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    public void quack() {
        if (quackBehavior != null) {
            quackBehavior.doQuack();
        }
    }

    public void fly() {
        if (flyBehavior != null) {
            flyBehavior.doFly();
        }
    }
}
