package module_2.no7_abstract_class_and_interface.practice.p2;

public class CircleComparable extends Circle implements Comparable<CircleComparable> {

    public CircleComparable() { }

    public CircleComparable(double radius) {
        super(radius);
    }

    public CircleComparable(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(CircleComparable o) {
        double tmp= getRadius() - o.getRadius();
        return getRadius() > o.getRadius()? 1: -1;
    }
}
