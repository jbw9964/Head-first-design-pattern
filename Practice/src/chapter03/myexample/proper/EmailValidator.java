package chapter03.myexample.proper;

import java.util.regex.*;

public class EmailValidator extends PatternDecorator {

    private static final Pattern pattern = Pattern.compile(
            "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"
    );

    public EmailValidator(PatternDecorator decorator) {
        super(decorator);
    }

    @Override
    public boolean containsPattern(String string) {
        return pattern.matcher(string).find() && decorator.containsPattern(string);
    }

    @Override
    public String toString() {
        return decorator.toString() + "-Email";
    }
}
