public class TamGiac {
    private Diem A;
    private Diem B;
    private Diem C;

    public TamGiac() {
        this.A = new Diem();
        this.B = new Diem();
        this.C = new Diem();
    }

    public TamGiac(Diem A, Diem B, Diem C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

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

    public Diem getC() {
        return C;
    }

    public void setC(Diem C) {
        this.C = C;
    }

    private double khoangCach(Diem A, Diem B) {
        double dx = A.getX() - B.getX();
        double dy = A.getY() - B.getY();

        return Math.sqrt(dx * dx + dy * dy);
    }

    public double tinhChuVi() {
        double a = khoangCach(B, C);
        double b = khoangCach(A, C);
        double c = khoangCach(A, B);

        return a + b + c;
    }

    public double tinhDienTich() {
        double a = khoangCach(B, C);
        double b = khoangCach(A, C);
        double c = khoangCach(A, B);

        double p = tinhChuVi() / 2;

        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}