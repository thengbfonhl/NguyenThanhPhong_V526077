package buoi3.phanso;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this(0, 1);
    }

    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        setMauSo(mauSo);
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so phai khac 0");
        }

        if (mauSo < 0) {
            this.tuSo = -this.tuSo;
            this.mauSo = -mauSo;
        } else {
            this.mauSo = mauSo;
        }
    }

    public PhanSo cong(PhanSo ps) {
        int tuMoi = tuSo * ps.mauSo + mauSo * ps.tuSo;
        int mauMoi = mauSo * ps.mauSo;
        return taoPhanSoDaRutGon(tuMoi, mauMoi);
    }

    public PhanSo tru(PhanSo ps) {
        int tuMoi = tuSo * ps.mauSo - mauSo * ps.tuSo;
        int mauMoi = mauSo * ps.mauSo;
        return taoPhanSoDaRutGon(tuMoi, mauMoi);
    }

    public PhanSo nhan(PhanSo ps) {
        int tuMoi = tuSo * ps.tuSo;
        int mauMoi = mauSo * ps.mauSo;
        return taoPhanSoDaRutGon(tuMoi, mauMoi);
    }

    public PhanSo chia(PhanSo ps) {
        if (ps.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho phan so 0");
        }

        int tuMoi = tuSo * ps.mauSo;
        int mauMoi = mauSo * ps.tuSo;
        return taoPhanSoDaRutGon(tuMoi, mauMoi);
    }

    // Tra ve so am neu nho hon, 0 neu bang nhau, so duong neu lon hon.
    public int soSanh(PhanSo ps) {
        long veTrai = (long) tuSo * ps.mauSo;
        long vePhai = (long) ps.tuSo * mauSo;
        return Long.compare(veTrai, vePhai);
    }

    public void rutGon() {
        int ucln = timUCLN(Math.abs(tuSo), mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
    }

    public boolean laSoNguyen() {
        return tuSo % mauSo == 0;
    }

    private static PhanSo taoPhanSoDaRutGon(int tuSo, int mauSo) {
        PhanSo ketQua = new PhanSo(tuSo, mauSo);
        ketQua.rutGon();
        return ketQua;
    }

    private static int timUCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
