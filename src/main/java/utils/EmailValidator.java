package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    public static boolean Match(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        Pattern patt = Pattern.compile(EMAIL_REGEX);
        Matcher match = patt.matcher(email);
        return match.matches();
    }
}
