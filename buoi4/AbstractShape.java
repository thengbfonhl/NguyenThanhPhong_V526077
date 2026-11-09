package buoi4;

/**
 * Lớp trừu tượng AbstractShape cài đặt interface Shape.
 * Cung cấp cài đặt chung cho các phép tính khoảng cách (distance)
 * dựa trên tâm (center) của hình, cũng như các phương thức tiện ích khác.
 */
public abstract class AbstractShape implements Shape {

    @Override
    public double distance() {
        Point center = getCenter();
        return center != null ? center.distance() : 0.0;
    }

    @Override
    public double distance(Point point) {
        if (point == null) {
            throw new IllegalArgumentException("Diem point khong duoc null.");
        }
        Point center = getCenter();
        return center != null ? center.distance(point) : 0.0;
    }

    @Override
    public double distance(Shape other) {
        if (other == null) {
            throw new IllegalArgumentException("Hinh other khong duoc null.");
        }
        Point center = getCenter();
        Point otherCenter = other.getCenter();
        if (center == null || otherCenter == null) {
            return 0.0;
        }
        return center.distance(otherCenter);
    }

    @Override
    public void rotate(double angle) {
        // Mac dinh xoay quanh tam cua hinh
        Point center = getCenter();
        if (center != null) {
            rotate(angle, center);
        }
    }

    @Override
    public String toString() {
        return String.format("%s [Chu vi: %.2f, Dien tich: %.2f, Tam: %s]",
                getName(), perimeter(), area(), getCenter());
    }
}
