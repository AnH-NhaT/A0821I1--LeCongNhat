package module_2.no7_abstract_class_and_interface.practice.p3;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return o1.getRadius()> o2.getRadius()? 1: -1;
    }
}
