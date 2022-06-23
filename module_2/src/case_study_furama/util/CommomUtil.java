package case_study_furama.util;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CommomUtil {

    public static <T extends Enum<T>> boolean enumContains(Class<T> enumerator, String value) {
        for (T c : enumerator.getEnumConstants()) {
            if (c.name().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }

    public static Scanner getScanner() {
        return new Scanner(System.in);
    }

    public static DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("dd/MM/yyyy");
    }
}
