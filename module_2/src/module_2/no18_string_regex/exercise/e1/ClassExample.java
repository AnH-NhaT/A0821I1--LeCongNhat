package module_2.no18_string_regex.exercise.e1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private static final String CLASS_REGEX = "^[CAP]\\d{4}[KHLGIM]$";

    /*  Bắt đầu bằng một ký tự chữ hoa C hoặc A hoặc P
        Không chứa các ký tự đặc biệt
        Theo sau ký tự bắt đầu là 4 ký tự số
        Kết thúc phải là 1 trong những ký tự chữ hoa sau: G, H, I, K, L, M
    */
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
