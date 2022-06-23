package module_2.no11_stack_queue.exercise.e4;

import java.util.*;

class DecimalBinaryStack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Create Stack object
        Stack<Integer> stack = new Stack<>();

        // User input
        System.out.print("Enter decimal number: ");
        int num = in.nextInt();

        while (num != 0) {
            int d = num % 2;
            stack.push(d);
            num /= 2;
        }

        System.out.print("Binary representation is:");
        while (!(stack.isEmpty())) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }
}