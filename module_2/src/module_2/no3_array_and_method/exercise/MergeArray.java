package module_2.no3_array_and_method.exercise;

public class MergeArray {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {6, 7, 8, 9, 0};
        int[] C = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i];
        }
        int temp = 0;
        for (int i = A.length; i < C.length; i++) {
            C[i] = B[temp];
            temp++;
        }
        System.out.println("Array A:");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        System.out.println("Array B:");
        for (int i = 0; i < B.length; i++) {
            System.out.print(B[i] + " ");
        }
        System.out.println();
        System.out.println("Array C:");
        // call function
        int[] assign = mergeTwo(A, B);
        for (int i = 0; i < assign.length; i++) {
            System.out.print(assign[i] + " ");
        }
    }

    public static int[] mergeTwo(int[] A, int[] B) {
        int[] C = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            C[i] = A[i];
        }
        int temp = 0;
        for (int i = A.length; i < C.length; i++) {
            C[i] = B[temp];
            temp++;
        }
        return C;
    }
}
