package module_2.no7_abstract_class_and_interface.exercise.resizeable;

public class Test {
    public static void main(String[] args) {
        Resizeable[] resizeable = new Resizeable[3];
        resizeable[0] = new Circle(5, "red", true);
        resizeable[1] = new Rectangle("yellow", false, 5, 9);
        resizeable[2] = new Square(15, "blue", false);

        for (Resizeable e : resizeable) {
            if (e instanceof Circle) {
                e.resize(50);
                System.out.println(e);
            } else if (e instanceof Rectangle) {
                e.resize(50);
                System.out.println(e);
            } else if (e instanceof Square) {
                e.resize(50);
                System.out.println(e);
            }
        }
    }
}