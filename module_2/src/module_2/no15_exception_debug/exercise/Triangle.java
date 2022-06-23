package module_2.no15_exception_debug.exercise;

public class Triangle {
    private int side1;
    private int side2;
    private int side3;

    Triangle(int side1, int side2, int side3) throws IllegalTriangleException {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        if (side1 < 0 || side2 < 0 || side3 < 0) {
            throw new IllegalTriangleException("error: side input < 0");
        } else if (side1 + side2 < side3 || side1 + side3 < side2 || side2 + side3 < side1) {
            throw new IllegalTriangleException("Not a triangle");
        }
    }


    int perimeter() {
        int perimeter = side1 + side2 + side3;
        return perimeter;
    }
}