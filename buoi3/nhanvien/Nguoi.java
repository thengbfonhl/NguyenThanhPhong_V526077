package buoi3.nhanvien;

import java.util.Scanner;

public class Nguoi {
    private String hoTen;
    private int tuoi;

    public Nguoi() {
        this("", 0);
    }

    public Nguoi(String hoTen, int tuoi) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        this.hoTen = sc.nextLine();
        System.out.print("Nhap tuoi: ");
        while (true) {
            try {
                this.tuoi = Integer.parseInt(sc.nextLine().trim());
                if (this.tuoi < 0) {
                    System.out.print("Tuoi phai >= 0. Nhap lai: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Tuoi khong hop le. Nhap lai: ");
            }
        }
    }

    public void xuat() {
        System.out.println("Ho ten: " + hoTen + ", Tuoi: " + tuoi);
    }

    @Override
    public String toString() {
        return "Nguoi{hoTen='" + hoTen + "', tuoi=" + tuoi + "}";
    }
}

