package chapter03.myexample.proper;

import java.util.regex.*;

public class IpAddressValidator extends PatternDecorator {

    private static final Pattern pattern = Pattern.compile(
            "\\b(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:(?:2([0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9]))\\b"
    );

    public IpAddressValidator(PatternDecorator decorator) {
        super(decorator);
    }

    @Override
    public boolean containsPattern(String string) {
        return pattern.matcher(string).find() && decorator.containsPattern(string);
    }

    @Override
    public String toString() {
        return decorator.toString() + "-IpAddress";
    }
}
