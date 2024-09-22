import com.sun.jdi.LongValue;

import static java.lang.Character.isDigit;
import static java.lang.Character.isWhitespace;

public class Main {
    public static void main(String[] args) {
        Telephon t1 = new Telephon("iphone XS Max", "(903)472-99-36");
        System.out.println(t1.toString());
        char charValue = '3';

        // Assign char variable to long variable
        long longValue = charValue(charValue);

        System.out.println("char value: " + charValue);
        System.out.println("long value: " + longValue);
    }
}
