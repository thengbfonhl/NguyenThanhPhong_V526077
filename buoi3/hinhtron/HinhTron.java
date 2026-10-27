package buoi3.hinhtron;

public class HinhTron {
    private double x;
    private double y;
    private double r;
    public HinhTron(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }

    public HinhTron() {
        this.x = 3;
        this.y = 6;
        this.r = 7;
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

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public String toString() {
        return "HinhTron{" +
                "x=" + x +
                ", y=" + y +
                ", r=" + r +
                '}';
    }

    public double dienTich() {
        return Math.PI * r * r;
    }

    public void tinhTien(double d) {
        this.x += d;
        this.y += d;
    }
}
