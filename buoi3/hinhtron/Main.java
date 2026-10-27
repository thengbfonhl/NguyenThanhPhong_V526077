package buoi3.hinhtron;

public class Main {
    public static void main(String[] args) {
        HinhTron ht1 = new HinhTron(1,1,3.5);
        HinhTron ht2 = new HinhTron();
        System.out.println(ht1);
        System.out.println(ht2);
        System.out.println("dien tich hinh tron 1 la: " + ht1.dienTich());
        System.out.println("dien tich hinh tron 2 la: " + ht2.dienTich());

        if(ht1.dienTich() > ht2.dienTich()) {
            System.out.println("Hinh tron 1 co dien tich lon hon hinh tron 2");
        } else if(ht1.dienTich() < ht2.dienTich()) {
            System.out.println("Hinh tron 2 co dien tich lon hon hinh tron 1");
        } else {
            System.out.println("Hai hinh tron co dien tich bang nhau");
        }

        ht1.tinhTien(2);
        ht2.tinhTien(4);
        System.out.println("Sau khi tinh tien:");
        System.out.println(ht1);
        System.out.println(ht2);

    }
}
