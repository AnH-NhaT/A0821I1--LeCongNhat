package haitt_demo.ss14_sort;

public class Sort {
    private static Integer[] integers = {14, 3, 6, 5};

    public void sortBubble() {
        boolean isSwap = true;
        //Tại sao chúng ta lại bắt đầu từ 1 mà không phải là 0.
        for (int i = 1; i < integers.length && isSwap; i++) {
            isSwap = false;
            //Tại sao lại - i => Giảm số lượng phần tử với mỗi vòng lặp i.
            for (int j = 0; j < integers.length - i; j++) {
                if (integers[j] > integers[j + 1]) {
                    //Thuật toán đổi chổ 2 số
                    int temp = integers[j];
                    integers[j] = integers[j + 1];
                    integers[j + 1] = temp;
                    isSwap = true;
                }
            }
        }
    }


    public void sortInsert() {
        for (int i = 1; i < integers.length; i++) {
            int key = integers[i];
            int j = i - 1;
            while (j >= 0 && integers[j] > key) {
                integers[j + 1] = integers[j];
                j--;
            }
            integers[j + 1] = key;
        }
    }


    public void sortSelect() {
        for (int i = 0; i < integers.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < integers.length; j++) {
                if (integers[j] < integers[min_index]) {
                    min_index = j;
                }
            }
            if (min_index != i) {
                int temp = integers[min_index];
                integers[min_index] = integers[i];
                integers[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Sort sort = new Sort();
        sort.sortInsert();
    }
}
