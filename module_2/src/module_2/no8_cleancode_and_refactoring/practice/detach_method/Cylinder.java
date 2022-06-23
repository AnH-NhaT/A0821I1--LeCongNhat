package module_2.no8_cleancode_and_refactoring.practice.detach_method;

public class Cylinder {
    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI  * radius;
    }

}
