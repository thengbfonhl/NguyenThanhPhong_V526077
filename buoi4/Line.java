package buoi4;

/**
 * Lớp Line biểu diễn một đoạn thẳng trong không gian 2D,
 * được xác định bởi 2 điểm đầu mút p1 và p2.
 */
public class Line extends AbstractShape {
    private Point p1;
    private Point p2;

    // Constructors
    public Line() {
        this(new Point(0, 0), new Point(1, 1));
    }

    public Line(Point p1, Point p2) {
        this.p1 = p1 != null ? new Point(p1) : new Point(0, 0);
        this.p2 = p2 != null ? new Point(p2) : new Point(1, 1);
    }

    public Line(double x1, double y1, double x2, double y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    // Getters and Setters
    public Point getP1() {
        return new Point(p1);
    }

    public void setP1(Point p1) {
        if (p1 != null) {
            this.p1 = new Point(p1);
        }
    }

    public Point getP2() {
        return new Point(p2);
    }

    public void setP2(Point p2) {
        if (p2 != null) {
            this.p2 = new Point(p2);
        }
    }

    /**
     * Tính độ dài đoạn thẳng.
     * @return độ dài
     */
    public double length() {
        return p1.distance(p2);
    }

    // ==================== NHÓM TÍNH TOÁN ====================

    @Override
    public double area() {
        return 0.0; // Doan thang khong co dien tich
    }

    @Override
    public double perimeter() {
        return length(); // Chu vi cua doan thang quy uoc la do dai cua no
    }

    // ==================== NHÓM BIẾN ĐỔI ====================

    @Override
    public void move(double dx, double dy) {
        p1.move(dx, dy);
        p2.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        // Xoay 2 dau mut quanh trung diem cua doan thang
        Point mid = getCenter();
        rotate(angle, mid);
    }

    @Override
    public void rotate(double angle, Point pivot) {
        p1.rotate(angle, pivot);
        p2.rotate(angle, pivot);
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ti le zoom phai > 0.");
        }
        // Phong to/thu nho tu trung diem (giu nguyen trung diem)
        Point mid = getCenter();
        p1.zoom(ratio, mid);
        p2.zoom(ratio, mid);
    }

    // ==================== BỔ TRỢ ====================

    @Override
    public Point getCenter() {
        // Trung diem cua doan thang
        return new Point((p1.getX() + p2.getX()) / 2.0, (p1.getY() + p2.getY()) / 2.0);
    }

    @Override
    public String getName() {
        return "Line";
    }

    @Override
    public String toString() {
        return String.format("Line[P1: %s, P2: %s, Do dai: %.2f]", p1, p2, length());
    }
}

