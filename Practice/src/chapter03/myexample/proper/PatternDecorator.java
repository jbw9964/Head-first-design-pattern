package chapter03.myexample.proper;

public abstract class PatternDecorator {

    protected final PatternDecorator decorator;

    public PatternDecorator(PatternDecorator decorator) {
        this.decorator = decorator;
    }

    public abstract boolean containsPattern(String string);

    @Override
    public String toString() {
        return "PatternDecorator@" + hashCode();
    }
}
