package module_2.no10_list.exercise.e2;

public class TestMyLinkedList {
    private static class Person{
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        MyLinkedList<Person> myLinkedList = new MyLinkedList<>();
        Person p1 = new Person("Truing",33);
        myLinkedList.addFirst(p1);
        Person p2 = new Person("Hai",22);
        myLinkedList.addFirst(p2);
        Person p3 = new Person("Kien",25);
        myLinkedList.addFirst(p3);
        Person p4 = new Person("Duc",31);
        myLinkedList.add(1,p4);
        Person p5 = new Person("Ha",24);
//        myLinkedList.addLast(p5);

        for (int i = 0; i < myLinkedList.size(); i++){
            Person p = (Person) myLinkedList.get(i);
            System.out.println(p.name);
        }
        int a1 = myLinkedList.indexOf(p1);
        int a2 = myLinkedList.indexOf(p2);
        int a3 = myLinkedList.indexOf(p3);
        int a4 = myLinkedList.indexOf(p4);
        int a5 = myLinkedList.indexOf(p5);
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println(a4);
        System.out.println(a5);
    }
}