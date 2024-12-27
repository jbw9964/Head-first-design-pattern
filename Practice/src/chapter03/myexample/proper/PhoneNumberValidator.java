package chapter03.myexample.proper;

import java.util.regex.*;

public class PhoneNumberValidator extends PatternDecorator {

    private static final Pattern pattern = Pattern.compile(
            "\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*"
    );

    public PhoneNumberValidator(PatternDecorator decorator) {
        super(decorator);
    }

    @Override
    public boolean containsPattern(String string) {
        return pattern.matcher(string).find() && decorator.containsPattern(string);
    }

    @Override
    public String toString() {
        return decorator.toString() + "-PhoneNumber";
    }
}
