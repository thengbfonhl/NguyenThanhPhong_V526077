package buoi4;

/**
 * Interface Shape định nghĩa các phương thức chung cho các hình trong không gian 2D.
 * Gồm 2 nhóm phương thức chính:
 * 1. Nhóm tính toán: diện tích (area), chu vi (perimeter), khoảng cách (distance).
 * 2. Nhóm biến đổi: tịnh tiến (move), xoay (rotate), thay đổi tỉ lệ (zoom).
 */
public interface Shape {

    // ==================== NHÓM TÍNH TOÁN ====================

    /**
     * Tính diện tích của hình.
     * @return diện tích (area)
     */
    double area();

    /**
     * Tính chu vi của hình.
     * @return chu vi (perimeter)
     */
    double perimeter();

    /**
     * Tính khoảng cách từ tâm hình này đến gốc tọa độ O(0, 0).
     * @return khoảng cách
     */
    double distance();

    /**
     * Tính khoảng cách từ tâm hình này đến một điểm Point.
     * @param point điểm cần tính khoảng cách
     * @return khoảng cách
     */
    double distance(Point point);

    /**
     * Tính khoảng cách từ tâm hình này đến tâm của một hình khác.
     * @param other hình khác
     * @return khoảng cách
     */
    double distance(Shape other);

    // ==================== NHÓM BIẾN ĐỔI ====================

    /**
     * Tịnh tiến hình theo vector (dx, dy).
     * @param dx độ dịch chuyển theo trục hoành X
     * @param dy độ dịch chuyển theo trục tung Y
     */
    void move(double dx, double dy);

    /**
     * Xoay hình quanh tâm của nó một góc (tính bằng độ - degrees).
     * @param angle góc xoay tính bằng độ
     */
    void rotate(double angle);

    /**
     * Xoay hình quanh một điểm mốc (pivot) bất kỳ một góc (tính bằng độ).
     * @param angle góc xoay tính bằng độ
     * @param pivot điểm làm tâm xoay
     */
    void rotate(double angle, Point pivot);

    /**
     * Thay đổi kích thước (phóng to/thu nhỏ) hình theo tỉ lệ ratio.
     * @param ratio tỉ lệ phóng to (ratio > 1) hoặc thu nhỏ (0 < ratio < 1)
     */
    void zoom(double ratio);

    // ==================== CÁC PHƯƠNG THỨC BỔ TRỢ ====================

    /**
     * Lấy tọa độ tâm/trọng tâm đại diện cho hình.
     * @return điểm tâm Point
     */
    Point getCenter();

    /**
     * Lấy tên của loại hình (Point, Circle, Line, Triangle, Rectangle,...).
     * @return tên loại hình
     */
    String getName();

    /**
     * Phương thức tương đương tiếng Việt cho area().
     */
    default double tinhDienTich() {
        return area();
    }

    /**
     * Phương thức tương đương tiếng Việt cho perimeter().
     */
    default double tinhChuVi() {
        return perimeter();
    }
}

