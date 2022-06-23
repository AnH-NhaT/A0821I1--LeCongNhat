package module_2.no11_stack_queue.exercise.e1;

import java.util.Arrays;
import java.util.Stack;

public class reversal {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 5, 7, 9, 6, 4, 6};
        Stack<Integer> stack = new Stack<>();
        for (int i : array) {
            stack.push(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        System.out.println(Arrays.toString(array));
// reverse a string using stack
        String str = "reversal";
        char[] charArr = str.toCharArray();
        Stack<Character> characterStack = new Stack<>();

        int i;
        for (i = 0; i < str.length(); ++i) {
            characterStack.push(charArr[i]);
        }

        for (i = 0; i < str.length(); ++i) {
            charArr[i] = characterStack.pop();
        }
        System.out.println(String.valueOf(charArr));
    }
}
