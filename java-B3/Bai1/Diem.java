public class Diem {
    private double x;
    private double y;

    // Hàm tạo không tham số
    public Diem() {
        this.x = 0;
        this.y = 0;
    }

    // Hàm tạo có tham số
    public Diem(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter và Setter cho x, y
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

    // Hiển thị tọa độ điểm
    public void hienThi() {
        System.out.println("(" + x + ", " + y + ")");
    }
}