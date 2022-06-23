package vehicle.common;

import java.util.regex.Pattern;

public class Validation {
    private static Pattern pattern;

    public static boolean validateCar(String regex) {
        pattern = Pattern.compile("^\\d{2}[AB]-\\d{3}\\.\\d{2}$");
        return pattern.matcher(regex).matches();
    }

    public static boolean validateTruck(String regex) {
        pattern = Pattern.compile("^\\d{2}C-\\d{3}\\.\\d{2}$");
        return pattern.matcher(regex).matches();
    }

    public static boolean validateMoto(String regex) {
        pattern = Pattern.compile("^\\d{2}-[A-Z][A-Z0-9]-\\d{3}\\.\\d{2}$");
        return pattern.matcher(regex).matches();
    }

    public static boolean validatePosNum(String regex) {
        pattern = Pattern.compile("^\\d{1,9}$");
        return pattern.matcher(regex).matches() &&
                Integer.parseInt(regex) > 0;
    }

    public static boolean validateYear(String regex) {
        pattern = Pattern.compile("^\\d{4}$");
        return pattern.matcher(regex).matches() &&
                (Integer.parseInt(regex) > 1920 &&
                        Integer.parseInt(regex) < 2022);
    }

    public static boolean validateLevel(String regex) {
        pattern = Pattern.compile("^GS|TS|THS$");
        return pattern.matcher(regex).matches();
    }
}
