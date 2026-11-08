package buoi3.nhanvien;

import java.util.Scanner;

public class NhanVien extends Nguoi {
    public static final double LCB = 1.5; // Luong co ban: 1.5 trieu dong (1,500,000 VND)

    private int snct;    // So nam cong tac
    private double hsl;  // He so luong

    public NhanVien() {
        super();
        this.snct = 0;
        this.hsl = 1.0;
    }

    public NhanVien(String hoTen, int tuoi, int snct, double hsl) {
        super(hoTen, tuoi);
        this.snct = snct;
        this.hsl = hsl;
    }

    public int getSnct() {
        return snct;
    }

    public void setSnct(int snct) {
        this.snct = snct;
    }

    public double getHsl() {
        return hsl;
    }

    public void setHsl(double hsl) {
        this.hsl = hsl;
    }

    public int getSoNamCongTac() {
        return snct;
    }

    public void setSoNamCongTac(int snct) {
        this.snct = snct;
    }

    public double getHeSoLuong() {
        return hsl;
    }

    public void setHeSoLuong(double hsl) {
        this.hsl = hsl;
    }

    public double tinhPhuCap() {
        return 0.2 * snct;
    }

    public double tinhLuong() {
        return LCB * hsl + tinhPhuCap();
    }

    public double tinhTienLuong() {
        return tinhLuong();
    }

    public double tinhLuongVND() {
        return tinhLuong() * 1_000_000;
    }

    @Override
    public void nhap(Scanner sc) {
        super.nhap(sc);

        System.out.print("Nhap so nam cong tac (snct): ");
        while (true) {
            try {
                this.snct = Integer.parseInt(sc.nextLine().trim());
                if (this.snct < 0) {
                    System.out.print("So nam cong tac phai >= 0. Nhap lai: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("So nam cong tac khong hop le. Nhap lai: ");
            }
        }

        System.out.print("Nhap he so luong (hsl): ");
        while (true) {
            try {
                this.hsl = Double.parseDouble(sc.nextLine().trim());
                if (this.hsl <= 0) {
                    System.out.print("He so luong phai > 0. Nhap lai: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("He so luong khong hop le. Nhap lai: ");
            }
        }
    }

    @Override
    public void xuat() {
        System.out.printf("Ho ten: %-18s | Tuoi: %2d | SNCT: %2d nam | HSL: %4.2f | Phu cap: %5.2f trieu | Tien luong: %6.2f trieu (%,.0f VND)%n",
                getHoTen(), getTuoi(), snct, hsl, tinhPhuCap(), tinhLuong(), tinhLuongVND());
    }

    @Override
    public String toString() {
        return "NhanVien{" +
                "hoTen='" + getHoTen() + '\'' +
                ", tuoi=" + getTuoi() +
                ", snct=" + snct +
                ", hsl=" + hsl +
                ", phuCap=" + String.format("%.2f", tinhPhuCap()) + " trieu" +
                ", tienLuong=" + String.format("%.2f", tinhLuong()) + " trieu (" + String.format("%,.0f", tinhLuongVND()) + " VND)" +
                '}';
    }
}
