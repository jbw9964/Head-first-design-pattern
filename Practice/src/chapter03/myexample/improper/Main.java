package chapter03.myexample.improper;

public class Main {

    public static void main(String[] args) {
        String str = """
                Hello! My name is jbw9964.
                                
                Email : jbw9964@gmail.com
                Phone : 010-1234-5678
                                
                Good bye!
                """;

        PatternValidator validator = new PatternValidator();

        System.out.println(validator.containsEmail("jbw9964@gmail.com"));
        System.out.println(validator.containsIpAddress("115.20.163.233"));
        System.out.println(validator.containsPhoneNum("01063921952"));

        System.out.println(
                "Contain Email \t\t\t: " + validator.containsEmail(str)
        );
        System.out.println(
                "Contain IP Address \t: " + validator.containsIpAddress(str)
        );
        System.out.println(
                "Contain Phone Num \t: " + validator.containsPhoneNum(str)
        );
    }
}
