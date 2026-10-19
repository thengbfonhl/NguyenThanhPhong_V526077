public class ChuNhat {
    private Diem A;
    private Diem B;

    public ChuNhat() {
        this.A = new Diem();
        this.B = new Diem();
    }

    public ChuNhat(Diem A, Diem B) {
        this.A = A;
        this.B = B;
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

    public double tinhChieuDai() {
        return Math.abs(B.getX() - A.getX());
    }

    public double tinhChieuRong() {
        return Math.abs(B.getY() - A.getY());
    }

    public double tinhChuVi() {
        return 2 * (tinhChieuDai() + tinhChieuRong());
    }

    public double tinhDienTich() {
        return tinhChieuDai() * tinhChieuRong();
    }
}