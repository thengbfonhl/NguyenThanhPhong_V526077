package buoi3.diem;

public class Diem3D extends Diem2D {
    private double z;

    public Diem3D() {
        this(0, 0, 0);
    }

    public Diem3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double khoangCach(Diem3D diem3D) {
        if (diem3D == null) {
            throw new IllegalArgumentException("Diem khong duoc null");
        }

        double deltaX = getX() - diem3D.getX();
        double deltaY = getY() - diem3D.getY();
        double deltaZ = z - diem3D.z;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY + deltaZ * deltaZ);
    }

    @Override
    public Diem3D doiXungQuaGocToaDo() {
        return new Diem3D(-getX(), -getY(), -z);
    }

    public void tinhTien(double deltaX, double deltaY, double deltaZ) {
        super.tinhTien(deltaX, deltaY);
        z += deltaZ;
    }

    @Override
    public String toString() {
        return "Diem3D{x=" + getX() + ", y=" + getY() + ", z=" + z + "}";
    }
}
