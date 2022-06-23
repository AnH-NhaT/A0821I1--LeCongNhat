package module_2.no10_list.exercise.e1;

import java.util.ArrayList;

public class MyListTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        MyList<Integer> listInteger = new MyList<>();
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);
        listInteger.add(5);
        listInteger.add(6);
        listInteger.remove(2);
        listInteger.add(2, 19);
        listInteger.add(5, 29);
        MyList<Integer> testClone = listInteger.clone();
        System.out.println(testClone);
//        listInteger.get(3);
//        listInteger.clear();
//        listInteger.contains(2);
//        listInteger.indexOf(2);
    }
}