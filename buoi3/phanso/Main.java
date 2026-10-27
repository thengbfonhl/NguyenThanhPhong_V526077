package buoi3.phanso;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhanSo ps1 = new PhanSo(3, 4);
        PhanSo ps2 = new PhanSo(2, 3);

        System.out.println("=== CAC PHEP TOAN PHAN SO ===");
        System.out.println("ps1 = " + ps1);
        System.out.println("ps2 = " + ps2);
        System.out.println("Tong: " + ps1.cong(ps2));
        System.out.println("Hieu: " + ps1.tru(ps2));
        System.out.println("Tich: " + ps1.nhan(ps2));
        System.out.println("Thuong: " + ps1.chia(ps2));
        hienThiKetQuaSoSanh(ps1, ps2);

        PhanSo chuaRutGon = new PhanSo(12, -18);
        System.out.println("Truoc khi rut gon: " + chuaRutGon);
        chuaRutGon.rutGon();
        System.out.println("Sau khi rut gon: " + chuaRutGon);

        List<PhanSo> danhSachPS = Arrays.asList(
                new PhanSo(1, 2),
                new PhanSo(7, 3),
                new PhanSo(-4, 5),
                new PhanSo(6, 3),
                new PhanSo(5, 4));

        System.out.println("\n=== TAP HOP PHAN SO ===");
        System.out.println("Danh sach: " + danhSachPS);
        System.out.println("Phan so lon nhat: " + timPhanSoLonNhat(danhSachPS));
        System.out.println("Tong cac phan so: " + tinhTong(danhSachPS));
        System.out.println("So phan so khong phai so nguyen: "
                + demPhanSoKhongNguyen(danhSachPS));
    }

    private static void hienThiKetQuaSoSanh(PhanSo ps1, PhanSo ps2) {
        int ketQua = ps1.soSanh(ps2);
        if (ketQua > 0) {
            System.out.println(ps1 + " lon hon " + ps2);
        } else if (ketQua < 0) {
            System.out.println(ps1 + " nho hon " + ps2);
        } else {
            System.out.println(ps1 + " bang " + ps2);
        }
    }

    private static PhanSo timPhanSoLonNhat(List<PhanSo> danhSachPS) {
        if (danhSachPS.isEmpty()) {
            throw new IllegalArgumentException("Danh sach phan so dang rong");
        }

        PhanSo lonNhat = danhSachPS.get(0);
        for (int i = 1; i < danhSachPS.size(); i++) {
            if (danhSachPS.get(i).soSanh(lonNhat) > 0) {
                lonNhat = danhSachPS.get(i);
            }
        }
        return lonNhat;
    }

    private static PhanSo tinhTong(List<PhanSo> danhSachPS) {
        PhanSo tong = new PhanSo();
        for (PhanSo phanSo : danhSachPS) {
            tong = tong.cong(phanSo);
        }
        return tong;
    }

    private static int demPhanSoKhongNguyen(List<PhanSo> danhSachPS) {
        int soLuong = 0;
        for (PhanSo phanSo : danhSachPS) {
            if (!phanSo.laSoNguyen()) {
                soLuong++;
            }
        }
        return soLuong;
    }
}
