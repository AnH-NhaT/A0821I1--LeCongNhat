package module_2.no6_inheritance.exercise.point2d_3d;

public class Point3D extends Point2D {
    private float z = 0;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        this.z = z;
        super.setX(x);
        super.setY(y);
    }

    public float[] getXYZ() {
        float[] floats = new float[3];
        floats[0] = getX();
        floats[1] = getY();
        floats[2] = z;
        return floats;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + z +
                '}';
    }
}
