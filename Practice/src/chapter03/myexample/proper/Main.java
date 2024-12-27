package chapter03.myexample.proper;

import java.util.*;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        String str = """
                Hello! My name is jbw9964.

                Email : jbw9964@gmail.com
                Phone : 010-1234-5678

                Good bye!
                """;

        List<Function<PatternDecorator, PatternDecorator>>
                emailAndPhoneValidator = List.of(
                EmailValidator::new, PhoneNumberValidator::new
        );

        List<Function<PatternDecorator, PatternDecorator>>
                emailAndIpAddressValidator = List.of(
                EmailValidator::new, IpAddressValidator::new
        );

        for (var constructors : List.of(emailAndPhoneValidator, emailAndIpAddressValidator)) {

            PatternDecorator validator = new PatternValidator();
            for (var constructor : constructors) {
                validator = constructor.apply(validator);
            }

            System.out.println(validator);
            System.out.println(validator.containsPattern(str));
        }

        // 근데 이게 의미가 있나??
    }
}
