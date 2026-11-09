package buoi4;

/**
 * Lớp Circle biểu diễn hình tròn trong không gian 2D.
 * Bao gồm tâm (center: Point) và bán kính (radius: double).
 */
public class Circle extends AbstractShape {
    private Point center;
    private double radius;

    // Constructors
    public Circle() {
        this(new Point(0, 0), 1.0);
    }

    public Circle(Point center, double radius) {
        this.center = center != null ? new Point(center) : new Point(0, 0);
        this.radius = Math.max(0.0, radius);
    }

    public Circle(double x, double y, double radius) {
        this(new Point(x, y), radius);
    }

    // Getters and Setters
    @Override
    public Point getCenter() {
        return new Point(center);
    }

    public void setCenter(Point center) {
        if (center != null) {
            this.center = new Point(center);
        }
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = Math.max(0.0, radius);
    }

    // ==================== NHÓM TÍNH TOÁN ====================

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    // ==================== NHÓM BIẾN ĐỔI ====================

    @Override
    public void move(double dx, double dy) {
        this.center.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        // Hinh tron xoay quanh tam cua no khong thay doi toa do tam va ban kinh
    }

    @Override
    public void rotate(double angle, Point pivot) {
        // Xoay tam cua hinh tron quanh diem pivot
        if (pivot != null) {
            this.center.rotate(angle, pivot);
        }
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ti le zoom phai > 0.");
        }
        this.radius *= ratio;
    }

    // ==================== BỔ TRỢ ====================

    @Override
    public String getName() {
        return "Circle";
    }

    @Override
    public String toString() {
        return String.format("Circle[Tam: %s, Ban kinh: %.2f, Chu vi: %.2f, Dien tich: %.2f]",
                center, radius, perimeter(), area());
    }
}

