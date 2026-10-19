import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap x cua diem A: ");
        double xA = sc.nextDouble();

        System.out.print("Nhap y cua diem A: ");
        double yA = sc.nextDouble();

        System.out.print("Nhap x cua diem B: ");
        double xB = sc.nextDouble();

        System.out.print("Nhap y cua diem B: ");
        double yB = sc.nextDouble();

        Diem A = new Diem(xA, yA);
        Diem B = new Diem(xB, yB);

        DuongThang dt = new DuongThang(A, B);

        System.out.println("Diem A: ");
        A.hienThi();

        System.out.println("Diem B: ");
        B.hienThi();

        System.out.println("Do dai AB: " + dt.tinhDoDai());

        sc.close();
    }
}