package buoi3.nhanvien;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<NhanVien> danhSach = new ArrayList<>();

        System.out.println("==================================================");
        System.out.println("         CHUONG TRINH QUAN LY NHAN VIEN          ");
        System.out.println("==================================================");

        System.out.print("Nhap so luong nhan vien n: ");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(sc.nextLine().trim());
                if (n <= 0) {
                    System.out.print("So luong nhan vien phai > 0. Nhap lai: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Vui long nhap so nguyen hop le: ");
            }
        }

        System.out.println("\n---------------- NHAP DANH SACH NHAN VIEN ----------------");
        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Nhan vien thu " + (i + 1) + " ---");
            NhanVien nv = new NhanVien();
            nv.nhap(sc);
            danhSach.add(nv);
        }

        System.out.println("\n================ DANH SACH NHAN VIEN VUA NHAP ================");
        hienThiDanhSach(danhSach);

        System.out.println("\n========= NHAN VIEN CO SO NAM CONG TAC NHIEU NHAT =========");
        timNhanVienSNCTCaoNhat(danhSach);

        System.out.println("\n====== DANH SACH NHAN VIEN THEO THU TU LUONG GIAM DAN ======");
        inDanhSachTheoLuongGiamDan(danhSach);

        sc.close();
    }

    public static void hienThiDanhSach(List<NhanVien> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }
        for (int i = 0; i < danhSach.size(); i++) {
            System.out.printf("%2d. ", (i + 1));
            danhSach.get(i).xuat();
        }
    }

    public static List<NhanVien> timNhanVienSNCTCaoNhat(List<NhanVien> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return new ArrayList<>();
        }

        int maxSnct = danhSach.get(0).getSnct();
        for (NhanVien nv : danhSach) {
            if (nv.getSnct() > maxSnct) {
                maxSnct = nv.getSnct();
            }
        }

        List<NhanVien> ketQua = new ArrayList<>();
        for (NhanVien nv : danhSach) {
            if (nv.getSnct() == maxSnct) {
                ketQua.add(nv);
            }
        }

        System.out.println("So nam cong tac nhieu nhat: " + maxSnct + " nam");
        System.out.println("Danh sach nhan vien dat tieu chi:");
        for (int i = 0; i < ketQua.size(); i++) {
            System.out.printf("%2d. ", (i + 1));
            ketQua.get(i).xuat();
        }
        return ketQua;
    }

    public static void inDanhSachTheoLuongGiamDan(List<NhanVien> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }

        List<NhanVien> danhSachSapXep = new ArrayList<>(danhSach);
        danhSachSapXep.sort((nv1, nv2) -> Double.compare(nv2.tinhLuong(), nv1.tinhLuong()));

        hienThiDanhSach(danhSachSapXep);
    }
}
