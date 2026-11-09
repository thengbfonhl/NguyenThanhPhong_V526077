package buoi4;

/**
 * Lớp Rectangle biểu diễn hình chữ nhật trong không gian 2D,
 * được xác định bởi đỉnh trên-trái (topLeft: Point), chiều rộng (width) và chiều cao (height).
 */
public class Rectangle extends AbstractShape {
    private Point topLeft;
    private double width;
    private double height;

    // Constructors
    public Rectangle() {
        this(new Point(0, 0), 4.0, 3.0);
    }

    public Rectangle(Point topLeft, double width, double height) {
        this.topLeft = topLeft != null ? new Point(topLeft) : new Point(0, 0);
        this.width = Math.max(0.0, width);
        this.height = Math.max(0.0, height);
    }

    public Rectangle(double x, double y, double width, double height) {
        this(new Point(x, y), width, height);
    }

    /**
     * Khởi tạo hình chữ nhật từ 2 điểm đường chéo đối diện p1 và p2.
     */
    public Rectangle(Point p1, Point p2) {
        if (p1 == null) p1 = new Point(0, 0);
        if (p2 == null) p2 = new Point(1, 1);

        double minX = Math.min(p1.getX(), p2.getX());
        double minY = Math.min(p1.getY(), p2.getY());
        double w = Math.abs(p2.getX() - p1.getX());
        double h = Math.abs(p2.getY() - p1.getY());

        this.topLeft = new Point(minX, minY);
        this.width = w;
        this.height = h;
    }

    // Getters and Setters
    public Point getTopLeft() {
        return new Point(topLeft);
    }

    public void setTopLeft(Point topLeft) {
        if (topLeft != null) {
            this.topLeft = new Point(topLeft);
        }
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = Math.max(0.0, width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = Math.max(0.0, height);
    }

    // ==================== NHÓM TÍNH TOÁN ====================

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    // ==================== NHÓM BIẾN ĐỔI ====================

    @Override
    public void move(double dx, double dy) {
        topLeft.move(dx, dy);
    }

    @Override
    public void rotate(double angle) {
        // Xoay quanh tâm của hình chữ nhật
        Point center = getCenter();
        long k = Math.round(angle / 90.0);
        // Nếu góc xoay là bội số lẻ của 90 độ (90, 270, -90,...), hoán đổi width và height
        if (Math.abs(angle - k * 90.0) < 1e-4 && Math.abs(k) % 2 != 0) {
            double temp = width;
            width = height;
            height = temp;
        }
        topLeft = new Point(center.getX() - width / 2.0, center.getY() - height / 2.0);
    }

    @Override
    public void rotate(double angle, Point pivot) {
        Point center = getCenter();
        if (pivot != null) {
            center.rotate(angle, pivot);
        }
        long k = Math.round(angle / 90.0);
        if (Math.abs(angle - k * 90.0) < 1e-4 && Math.abs(k) % 2 != 0) {
            double temp = width;
            width = height;
            height = temp;
        }
        topLeft = new Point(center.getX() - width / 2.0, center.getY() - height / 2.0);
    }

    @Override
    public void zoom(double ratio) {
        if (ratio <= 0) {
            throw new IllegalArgumentException("Ti le zoom phai > 0.");
        }
        Point center = getCenter();
        this.width *= ratio;
        this.height *= ratio;
        // Cập nhật lại topLeft để tâm hình giữ nguyên vị trí
        this.topLeft = new Point(center.getX() - width / 2.0, center.getY() - height / 2.0);
    }

    // ==================== BỔ TRỢ ====================

    @Override
    public Point getCenter() {
        return new Point(topLeft.getX() + width / 2.0, topLeft.getY() + height / 2.0);
    }

    @Override
    public String getName() {
        return "Rectangle";
    }

    @Override
    public String toString() {
        return String.format("Rectangle[Dinh tren-trai: %s, Rong: %.2f, Cao: %.2f, Chu vi: %.2f, Dien tich: %.2f]",
                topLeft, width, height, perimeter(), area());
    }
}

