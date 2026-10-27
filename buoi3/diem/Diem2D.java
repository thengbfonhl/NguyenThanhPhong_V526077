package buoi3.diem;

public class Diem2D {
    private double x;
    private double y;

    public Diem2D() {
        this(0, 0);
    }

    public Diem2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double khoangCach(Diem2D diem2D) {
        if (diem2D == null) {
            throw new IllegalArgumentException("Diem khong duoc null");
        }
        return Math.hypot(x - diem2D.x, y - diem2D.y);
    }

    public Diem2D doiXungQuaGocToaDo() {
        return new Diem2D(-x, -y);
    }

    public void tinhTien(double deltaX, double deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "Diem2D{x=" + x + ", y=" + y + "}";
    }
}
