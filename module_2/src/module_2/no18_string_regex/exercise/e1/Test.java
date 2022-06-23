package module_2.no18_string_regex.exercise.e1;

public class Test {
    private static ClassExample classExample;

    public static final String[] validClass = new String[]{"C0318G", "C4647K"};
    public static final String[] invalidClass = new String[]{"M0318G", "P0323A"};

    public static void main(String[] args) {
        classExample = new ClassExample();
        for (String clas : validClass) {
            boolean isValid = classExample.validate(clas);
            System.out.println("Class is " + clas + " is valid: " + isValid);
        }
        for (String clas : invalidClass) {
            boolean isValid = classExample.validate(clas);
            System.out.println("Class is " + clas + " is valid: " + isValid);
        }
    }
}
