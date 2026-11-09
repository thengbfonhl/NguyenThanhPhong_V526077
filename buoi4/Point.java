package buoi4;

import java.util.Objects;

/**
 * Lớp Point biểu diễn một điểm trong không gian 2D (x, y).
 * Cài đặt interface Shape (thông qua AbstractShape).
 */
public class Point extends AbstractShape {
    private double x;
    private double y;

    // Constructors
    public Point() {
        this(0.0, 0.0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        if (other != null) {
            this.x = other.x;
            this.y = other.y;
        } else {
            this.x = 0.0;
            this.y = 0.0;
        }
    }

    // Getters and Setters
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

    public void setLocation(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // ==================== NHÓM TÍNH TOÁN ====================

    @Override
    public double area() {
        return 0.0; // Diem khong co dien tich
    }

    @Override
    public double perimeter() {
        return 0.0; // Diem khong co chu vi
    }

    @Override
    public double distance() {
        // Khoang cach toi goc toa do O(0, 0)
        return Math.hypot(x, y);
    }

    @Override
    public double distance(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Diem other khong duoc null.");
        }
        return Math.hypot(this.x - other.x, this.y - other.y);
    }

    // ==================== NHÓM BIẾN ĐỔI ====================

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public void rotate(double angle) {
        // Voi Point, xoay quanh goc toa do O(0, 0) theo goc angle (do)
        rotate(angle, new Point(0, 0));
    }

    @Override
    public void rotate(double angle, Point pivot) {
        if (pivot == null) {
            pivot = new Point(0, 0);
        }
        double rad = Math.toRadians(angle);
        double cos = Math.cos(rad);
        double sin = Math.sin(rad);

        double dx = this.x - pivot.getX();
        double dy = this.y - pivot.getY();

        this.x = pivot.getX() + (dx * cos - dy * sin);
        this.y = pivot.getY() + (dx * sin + dy * cos);
    }

    @Override
    public void zoom(double ratio) {
        // Phong to/thu nho toa do so voi goc toa do O(0, 0)
        this.x *= ratio;
        this.y *= ratio;
    }

    /**
     * Phong to/thu nho toa do so voi mot tam pivot bat ky.
     */
    public void zoom(double ratio, Point pivot) {
        if (pivot == null) {
            zoom(ratio);
            return;
        }
        this.x = pivot.getX() + (this.x - pivot.getX()) * ratio;
        this.y = pivot.getY() + (this.y - pivot.getY()) * ratio;
    }

    // ==================== BỔ TRỢ ====================

    @Override
    public Point getCenter() {
        return new Point(this.x, this.y);
    }

    @Override
    public String getName() {
        return "Point";
    }

    @Override
    public String toString() {
        return String.format("Point(%.2f, %.2f)", x, y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Math.abs(point.x - x) < 1e-6 && Math.abs(point.y - y) < 1e-6;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

