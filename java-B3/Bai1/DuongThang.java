public class DuongThang {
    private Diem A;
    private Diem B;

    // Hàm tạo không tham số
    public DuongThang() {
        this.A = new Diem();
        this.B = new Diem();
    }

    // Hàm tạo có tham số
    public DuongThang(Diem A, Diem B) {
        this.A = A;
        this.B = B;
    }

    // Getter và Setter
    public Diem getA() {
        return A;
    }

    public void setA(Diem A) {
        this.A = A;
    }

    public Diem getB() {
        return B;
    }

    public void setB(Diem B) {
        this.B = B;
    }

    // Tính độ dài đoạn thẳng AB
    public double tinhDoDai() {
        double dx = B.getX() - A.getX();
        double dy = B.getY() - A.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }
}