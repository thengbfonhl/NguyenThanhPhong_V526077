package buoi4;

/**
 * Lớp Triangle biểu diễn hình tam giác trong không gian 2D,
 * được xác định bởi 3 đỉnh a, b, c.
 */
public class Triangle extends AbstractShape {
    private Point a;
    private Point b;
    private Point c;

    // Constructors
    public Triangle() {
        this(new Point(0, 0), new Point(3, 0), new Point(0, 4));
    }

    public Triangle(Point a, Point b, Point c) {
        this.a = a != null ? new Point(a) : new Point(0, 0);
        this.b = b != null ? new Point(b) : new Point(3, 0);
        this.c = c != null ? new Point(c) : new Point(0, 4);
    }

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    // Getters and Setters
    public Point getA() {
        return new Point(a);
    }

    public void setA(Point a) {
        if (a != null) {
            this.a = new Point(a);
        }
    }

    public Point getB() {
        return new Point(b);
    }

    public void setB(Point b) {
        if (b != null) {
            this.b = new Point(b);
        }
    }

    public Point getC() {
        return new Point(c);
    }

    public void setC(Point c) {
        if (c != null) {
            this.c = new Point(c);
        }
    }

    // Độ dài các cạnh
    public double getSideAB() {
        return a.distance(b);
    }

    public double getSideBC() {
        return b.distance(c);
    }

    public double getSideCA() {
        return c.distance(a);
    }

    // ==================== NHÓM TÍNH TOÁN ====================

    @Override
    public double perimeter() {
        return getSideAB() + getSideBC() + getSideCA();
    }

    @Override
    public double area() {
        // Công thức Heron
        double p = perimeter() / 2.0;
        double ab = getSideAB();
        double bc = getSideBC();
        double ca = getSideCA();
        double val = p * (p - ab) * (p - bc) * (p - ca);
        return val > 0 ? Math.sqrt(val) : 0.0;
    }

    // ==================== NHÓM BIẾN ĐỔI ====================

    @Override
    public void move(double dx, double dy) {
        a.move(dx, dy);
        b.move(dx, dy);
        c.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        // Xoay 3 đỉnh quanh trọng tâm G
        Point g = getCenter();
        rotate(angle, g);
    }

    @Override
    public void rotate(double angle, Point pivot) {
        a.rotate(angle, pivot);
        b.rotate(angle, pivot);
        c.rotate(angle, pivot);
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ti le zoom phai > 0.");
        }
        // Phóng to/thu nhỏ 3 đỉnh lấy trọng tâm G làm mốc
        Point g = getCenter();
        a.zoom(ratio, g);
        b.zoom(ratio, g);
        c.zoom(ratio, g);
    }

    // ==================== BỔ TRỢ ====================

    @Override
    public Point getCenter() {
        // Trọng tâm G = ((xa + xb + xc)/3, (ya + yb + yc)/3)
        return new Point(
                (a.getX() + b.getX() + c.getX()) / 3.0,
                (a.getY() + b.getY() + c.getY()) / 3.0
        );
    }

    @Override
    public String getName() {
        return "Triangle";
    }

    @Override
    public String toString() {
        return String.format("Triangle[A: %s, B: %s, C: %s, Chu vi: %.2f, Dien tich: %.2f]",
                a, b, c, perimeter(), area());
    }
}

