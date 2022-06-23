package module_2.no18_string_regex.exercise.e2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    private static final String PHONE_REGEX = "^84[0]{1}\\d{9}$";

    /* Số điện thoại hợp lệ cần đạt theo mẫu sau: (xx)-(0xxxxxxxxx)
        x là ký tự số
        Không chứa các ký tự đặc biệt
        Ví dụ số điện thoại hợp lệ: (84)-(0978489648)
        Ví dụ tên lớp không hợp lệ: (a8)-(22222222)
    */
    public boolean validate(String regex) {
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
