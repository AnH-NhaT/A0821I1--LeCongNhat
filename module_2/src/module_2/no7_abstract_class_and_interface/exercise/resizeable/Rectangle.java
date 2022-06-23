package module_2.no7_abstract_class_and_interface.exercise.resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double width;
    private double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.height = length;
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return "A Rectangle with width= " + width +
                ", height= " + height + " which is a subclass of " + super.toString();
    }

    @Override
    public void resize(double percent) {
        width *= percent / 100;
        height *= percent / 100;
    }
}