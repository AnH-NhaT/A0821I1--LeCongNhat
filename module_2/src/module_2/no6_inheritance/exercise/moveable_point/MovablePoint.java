package module_2.no6_inheritance.exercise.moveable_point;

public class MovablePoint extends Point {
    private float xSpeed = 0;
    private float ySpeed = 0;

    public MovablePoint() {
    }

    public MovablePoint(float x, float y) {
        super(x, y);
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        float[] floats = {getXSpeed(), getYSpeed()};
        return floats;
    }

    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," +
                "),speed=(" + getXSpeed() + "," + getYSpeed() + ")";
    }

    public float[] move() {
        super.setX(super.getX() + getXSpeed());
        super.setY(super.getY() + getYSpeed());
        float[] move = {super.getX(), super.getY()};
        return move;
    }
}
