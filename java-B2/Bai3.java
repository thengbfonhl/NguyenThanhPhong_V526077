import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap cac so nguyen: ");
        String s = sc.nextLine();

        String[] parts = s.trim().split("\\s+");

        int tong = 0;
        int n = parts.length;

        for (int i = 0; i < n; i++) {
            tong += Integer.parseInt(parts[i]);
        }

        System.out.println("So phan tu: " + n);
        System.out.println("Tong: " + tong);

        sc.close();
    }
}