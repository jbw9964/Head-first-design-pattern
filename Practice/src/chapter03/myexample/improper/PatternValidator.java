package chapter03.myexample.improper;

import java.util.regex.*;

public class PatternValidator {

    private final static Pattern EMAIL = Pattern.compile(
            "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b"
    );
    private final static Pattern IP_ADDRESS = Pattern.compile(
            "\\b(?:(?:2(?:[0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9])\\.){3}(?:(?:2([0-4][0-9]|5[0-5])|[0-1]?[0-9]?[0-9]))\\b"
    );
    private final static Pattern PHONE = Pattern.compile(
            "\\s*(?:\\+?(\\d{1,3}))?([-. (]*(\\d{3})[-. )]*)?((\\d{3})[-. ]*(\\d{2,4})(?:[-.x ]*(\\d+))?)\\s*"
    );

    public boolean containsEmail(String input) {
        return EMAIL.matcher(input).find();
    }

    public boolean containsIpAddress(String input) {
        return IP_ADDRESS.matcher(input).find();
    }

    public boolean containsPhoneNum(String input) {
        return PHONE.matcher(input).find();
    }
}
