package module_2.no2_loop_in_java.exercise;

public class ListPrimeLessThan100 {
    public static void main(String[] args) {
        int count = 0;
        int n = 2;
        while (count < 101) {
            boolean check = true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    check = false;
                }
            }
            if (check) {
                count++;
                System.out.println(n);
            }
            n++;
        }
    }
}