package product.common;

import java.util.regex.Pattern;

public class Validation {
    private static Pattern pattern;

    public static boolean validateCost(String check) {
        pattern = Pattern.compile("^\\d{4,15}$");
        return pattern.matcher(check).matches() && Integer.parseInt(check) > 0;
    }

    public static boolean validateEnter(String check) {
        pattern = Pattern.compile("^$");
        return pattern.matcher(check).matches();
    }
}
