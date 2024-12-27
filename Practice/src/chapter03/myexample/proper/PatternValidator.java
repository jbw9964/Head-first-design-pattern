package chapter03.myexample.proper;

public class PatternValidator extends PatternDecorator {

    public PatternValidator() {
        super(null);
    }

    @Override
    public boolean containsPattern(String string) {
        return true;
    }

    @Override
    public String toString() {
        return "PatternValidator";
    }
}
