package module_2.no18_string_regex.exercise.e2;

public class Test {
    private static PhoneExample phoneExample;

    public static final String[] validPhone = new String[]{"840978489648"};
    public static final String[] invalidPhone = new String[]{"8a346346346"};

    public static void main(String[] args) {
        phoneExample = new PhoneExample();
        for (String phone : validPhone) {
            boolean isValid = phoneExample.validate(phone);
            System.out.println("Phone is " + phone + " is valid: " + isValid);
        }
        for (String phone : invalidPhone) {
            boolean isValid = phoneExample.validate(phone);
            System.out.println("Phone is " + phone + " is valid: " + isValid);
        }
    }
}
