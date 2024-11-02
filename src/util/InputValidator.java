package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String PATTERN = "^(Student|Teacher|TA)\\s+([A-Za-z]+,[A-Za-z]+)\\s+(\\d{5}|0)\\s+(\\d{5}|0)\\s+(\\d{10})$";
    public static boolean isValidInput(String input) {
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

