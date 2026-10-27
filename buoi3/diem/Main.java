package buoi3.diem;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Diem2D diem2DThuNhat = new Diem2D(1, 2);
        Diem2D diem2DThuHai = new Diem2D(-3, 4);
        Diem3D diem3DThuNhat = new Diem3D(1, 2, 3);
        Diem3D diem3DThuHai = new Diem3D(-2, 1, 4);

        System.out.println("Khoang cach hai diem 2D: " + diem2DThuNhat.khoangCach(diem2DThuHai));
        System.out.println("Khoang cach hai diem 3D: " + diem3DThuNhat.khoangCach(diem3DThuHai));

        diem2DThuNhat.tinhTien(2, -1);
        diem3DThuNhat.tinhTien(2, -1, 3);
        System.out.println("Diem 2D sau khi tinh tien: " + diem2DThuNhat);
        System.out.println("Diem 3D sau khi tinh tien: " + diem3DThuNhat);

        List<Diem2D> danhSachDiem = new ArrayList<>();
        danhSachDiem.add(diem2DThuNhat);
        danhSachDiem.add(diem2DThuHai);
        danhSachDiem.add(diem3DThuNhat);
        danhSachDiem.add(diem3DThuHai);

        System.out.println("\nDanh sach ban dau:");
        hienThiDanhSach(danhSachDiem);
        System.out.println("Tong khoang cach giua moi cap diem 2D: " + tinhTongKhoangCach2D(danhSachDiem));
        System.out.println("Tong khoang cach giua moi cap diem 3D: " + tinhTongKhoangCach3D(danhSachDiem));

        int soDiemBanDau = danhSachDiem.size();
        for (int i = 0; i < soDiemBanDau; i++) {
            danhSachDiem.add(danhSachDiem.get(i).doiXungQuaGocToaDo());
        }

        System.out.println("\nDanh sach sau khi them cac diem doi xung:");
        hienThiDanhSach(danhSachDiem);
    }

    private static double tinhTongKhoangCach2D(List<Diem2D> danhSach) {
        List<Diem2D> cacDiem2D = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            if (!(diem instanceof Diem3D)) {
                cacDiem2D.add(diem);
            }
        }

        double tong = 0;
        for (int i = 0; i < cacDiem2D.size() - 1; i++) {
            for (int j = i + 1; j < cacDiem2D.size(); j++) {
                tong += cacDiem2D.get(i).khoangCach(cacDiem2D.get(j));
            }
        }
        return tong;
    }

    private static double tinhTongKhoangCach3D(List<Diem2D> danhSach) {
        List<Diem3D> cacDiem3D = new ArrayList<>();
        for (Diem2D diem : danhSach) {
            if (diem instanceof Diem3D) {
                cacDiem3D.add((Diem3D) diem);
            }
        }

        double tong = 0;
        for (int i = 0; i < cacDiem3D.size() - 1; i++) {
            for (int j = i + 1; j < cacDiem3D.size(); j++) {
                tong += cacDiem3D.get(i).khoangCach(cacDiem3D.get(j));
            }
        }
        return tong;
    }

    private static void hienThiDanhSach(List<Diem2D> danhSach) {
        for (Diem2D diem : danhSach) {
            System.out.println(diem);
        }
    }
}
