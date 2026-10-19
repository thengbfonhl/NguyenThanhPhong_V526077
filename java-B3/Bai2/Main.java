public class Main {
    public static void main(String[] args) {
        // Tam giac 1
        TamGiac tg1 = new TamGiac(
            new Diem(0, 0),
            new Diem(3, 0),
            new Diem(0, 4)
        );

        // Tam giac 2
        TamGiac tg2 = new TamGiac(
            new Diem(0, 0),
            new Diem(6, 0),
            new Diem(0, 8)
        );

        // Chu nhat 1
        ChuNhat cn1 = new ChuNhat(
            new Diem(0, 0),
            new Diem(4, 3)
        );

        // Chu nhat 2
        ChuNhat cn2 = new ChuNhat(
            new Diem(1, 2),
            new Diem(7, 6)
        );

        // Hinh tron 1
        HinhTron ht1 = new HinhTron(
            new Diem(0, 0), 5
        );

        // Hinh tron 2
        HinhTron ht2 = new HinhTron(
            new Diem(2, 3), 3
        );

        // In ket qua
        System.out.println("=== TAM GIAC 1 ===");
        System.out.println("Chu vi: " + tg1.tinhChuVi());
        System.out.println("Dien tich: " + tg1.tinhDienTich());

        System.out.println("\n=== TAM GIAC 2 ===");
        System.out.println("Chu vi: " + tg2.tinhChuVi());
        System.out.println("Dien tich: " + tg2.tinhDienTich());

        System.out.println("\n=== CHU NHAT 1 ===");
        System.out.println("Chu vi: " + cn1.tinhChuVi());
        System.out.println("Dien tich: " + cn1.tinhDienTich());

        System.out.println("\n=== CHU NHAT 2 ===");
        System.out.println("Chu vi: " + cn2.tinhChuVi());
        System.out.println("Dien tich: " + cn2.tinhDienTich());

        System.out.println("\n=== HINH TRON 1 ===");
        System.out.println("Chu vi: " + ht1.tinhChuVi());
        System.out.println("Dien tich: " + ht1.tinhDienTich());

        System.out.println("\n=== HINH TRON 2 ===");
        System.out.println("Chu vi: " + ht2.tinhChuVi());
        System.out.println("Dien tich: " + ht2.tinhDienTich());
    }
}