package buoi4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Chương trình chính quản lý không gian các hình (Shape) cho ứng dụng Paint:
 * 1. Tạo tập các hình ngẫu nhiên (Point, Circle, Line, Triangle, Rectangle).
 * 2. Hiển thị danh sách các hình đã tạo.
 * 3. Tính tổng chu vi, tổng diện tích; tìm hình có diện tích lớn nhất, nhỏ nhất.
 * 4. Biến đổi các hình bằng cách phóng to với tỉ lệ ratio (zoom).
 * 5. Các biến đổi nâng cao: tịnh tiến (move), xoay (rotate), tính khoảng cách (distance).
 */
public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("================================================================================");
        System.out.println("             CHUONG TRINH QUAN LY KHONG GIAN CAC HINH (PAINT OOP)               ");
        System.out.println("================================================================================");

        int n = 6;
        System.out.print("Nhap so luong hinh ngau nhien can tao (mac dinh 6, nhan Enter de su dung): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                try {
                    int val = Integer.parseInt(line);
                    if (val > 0) {
                        n = val;
                    } else {
                        System.out.println("So luong <= 0, he thong su dung mac dinh n = 6.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Gia tri khong hop le, su dung mac dinh n = 6.");
                }
            }
        }

        // 1. Tạo danh sách các hình ngẫu nhiên
        List<Shape> danhSachHinh = taoDanhSachNgauNhien(n);

        // 2. Hiển thị danh sách
        System.out.println("\n>>> 1. DANH SACH CAC HINH DUOC TAO NGAU NHIEN:");
        hienThiDanhSach(danhSachHinh);

        // 3. Tính tổng chu vi & diện tích
        System.out.println("\n>>> 2. TONG CHU VI VA TONG DIEN TICH:");
        double tongChuVi = tinhTongChuVi(danhSachHinh);
        double tongDienTich = tinhTongDienTich(danhSachHinh);
        System.out.printf(" - Tong chu vi cac hinh : %10.2f%n", tongChuVi);
        System.out.printf(" - Tong dien tich cac hinh: %10.2f%n", tongDienTich);

        // 4. Tìm hình có diện tích lớn nhất / nhỏ nhất
        System.out.println("\n>>> 3. TIM HINH CO DIEN TICH LON NHAT VA NHO NHAT:");
        timVaInHinhDienTichLonNhat(danhSachHinh);
        timVaInHinhDienTichNhoNhat(danhSachHinh);

        // 5. Phóng to các hình theo tỉ lệ ratio
        System.out.println("\n>>> 4. BIEN DOI HINH: PHONG TO VOI TI LE RATIO:");
        double ratio = 2.0;
        System.out.print("Nhap ti le zoom ratio (mac dinh 2.0, nhan Enter de su dung): ");
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                try {
                    double rVal = Double.parseDouble(line);
                    if (rVal > 0) {
                        ratio = rVal;
                    } else {
                        System.out.println("Ti le phai > 0, su dung mac dinh ratio = 2.0.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Gia tri khong hop le, su dung mac dinh ratio = 2.0.");
                }
            }
        }

        System.out.printf("-> Tien hanh zoom voi ratio = %.2f...%n", ratio);
        phongToDanhSach(danhSachHinh, ratio);

        System.out.println("\n--- DANH SACH SAU KHI PHONG TO (ZOOM) ---");
        hienThiDanhSach(danhSachHinh);

        System.out.println("\n--- TONG CHU VI VA DIEN TICH SAU KHI ZOOM ---");
        System.out.printf(" - Tong chu vi moi : %10.2f%n", tinhTongChuVi(danhSachHinh));
        System.out.printf(" - Tong dien tich moi: %10.2f%n", tinhTongDienTich(danhSachHinh));

        // 6. Menu tương tác nâng cao
        boolean tiepTuc = true;
        while (tiepTuc) {
            inMenu();
            System.out.print("Chon chuc nang (0 - 8): ");
            if (!sc.hasNextLine()) {
                break;
            }
            String chon = sc.nextLine().trim();
            switch (chon) {
                case "1":
                    System.out.println("\n=== DANH SACH CAC HINH HIEN TAI ===");
                    hienThiDanhSach(danhSachHinh);
                    break;
                case "2":
                    System.out.println("\n=== TONG CHU VI & DIEN TICH ===");
                    System.out.printf("Tong chu vi : %.2f%n", tinhTongChuVi(danhSachHinh));
                    System.out.printf("Tong dien tich: %.2f%n", tinhTongDienTich(danhSachHinh));
                    break;
                case "3":
                    System.out.println("\n=== HINH CO DIEN TICH LON NHAT / NHO NHAT ===");
                    timVaInHinhDienTichLonNhat(danhSachHinh);
                    timVaInHinhDienTichNhoNhat(danhSachHinh);
                    break;
                case "4":
                    System.out.print("Nhap ti le zoom ratio (> 0): ");
                    try {
                        double r = Double.parseDouble(sc.nextLine().trim());
                        if (r > 0) {
                            phongToDanhSach(danhSachHinh, r);
                            System.out.printf("Da phong to danh sach voi ratio = %.2f.%n", r);
                            hienThiDanhSach(danhSachHinh);
                        } else {
                            System.out.println("Ti le phai > 0.");
                        }
                    } catch (Exception e) {
                        System.out.println("Ti le khong hop le.");
                    }
                    break;
                case "5":
                    System.out.print("Nhap vector tinh tien dx: ");
                    try {
                        double dx = Double.parseDouble(sc.nextLine().trim());
                        System.out.print("Nhap vector tinh tien dy: ");
                        double dy = Double.parseDouble(sc.nextLine().trim());
                        tinhTienDanhSach(danhSachHinh, dx, dy);
                        System.out.printf("Da tinh tien toan bo cac hinh theo vector (%.2f, %.2f).%n", dx, dy);
                        hienThiDanhSach(danhSachHinh);
                    } catch (Exception e) {
                        System.out.println("Toa do tinh tien khong hop le.");
                    }
                    break;
                case "6":
                    System.out.print("Nhap goc xoay angle (tinh bang do): ");
                    try {
                        double angle = Double.parseDouble(sc.nextLine().trim());
                        xoayDanhSach(danhSachHinh, angle);
                        System.out.printf("Da xoay toan bo cac hinh quanh tam mot goc %.2f do.%n", angle);
                        hienThiDanhSach(danhSachHinh);
                    } catch (Exception e) {
                        System.out.println("Goc xoay khong hop le.");
                    }
                    break;
                case "7":
                    tinhKhoangCachGiuaHaiHinh(danhSachHinh, sc);
                    break;
                case "8":
                    System.out.print("Nhap so luong hinh moi: ");
                    try {
                        int soLuongMoi = Integer.parseInt(sc.nextLine().trim());
                        if (soLuongMoi > 0) {
                            danhSachHinh = taoDanhSachNgauNhien(soLuongMoi);
                            System.out.printf("Da tao moi %d hinh ngau nhien.%n", soLuongMoi);
                            hienThiDanhSach(danhSachHinh);
                        }
                    } catch (Exception e) {
                        System.out.println("So luong khong hop le.");
                    }
                    break;
                case "0":
                    System.out.println("Cam on ban da su dung chuong trinh! Tam biet.");
                    tiepTuc = false;
                    break;
                default:
                    System.out.println("Lua chon khong hop le, vui long chon lai (0 - 8).");
            }
        }

        sc.close();
    }

    private static void inMenu() {
        System.out.println("\n----------------------------- MENU CHUC NANG -----------------------------");
        System.out.println("1. Hien thi danh sach cac hinh");
        System.out.println("2. Tinh tong chu vi va tong dien tich");
        System.out.println("3. Tim hinh co dien tich lon nhat va nho nhat");
        System.out.println("4. Phong to/thu nho (zoom) cac hinh");
        System.out.println("5. Tinh tien (move) cac hinh");
        System.out.println("6. Xoay (rotate) cac hinh");
        System.out.println("7. Tinh khoang cach (distance) giua 2 hinh");
        System.out.println("8. Tao lai danh sach hinh ngau nhien moi");
        System.out.println("0. Thoat");
        System.out.println("--------------------------------------------------------------------------");
    }

    // ==================== 1. TẠO TẬP CÁC HÌNH NGẪU NHIÊN ====================

    /**
     * Tạo một danh sách ngẫu nhiên gồm n hình, đảm bảo có đủ các loại hình:
     * Point, Circle, Line, Triangle, Rectangle.
     */
    public static List<Shape> taoDanhSachNgauNhien(int n) {
        List<Shape> danhSach = new ArrayList<>();
        if (n <= 0) return danhSach;

        for (int i = 0; i < n; i++) {
            // Đảm bảo đủ các loại hình ở các vị trí đầu, sau đó sinh ngẫu nhiên
            int loai = (i < 5) ? i : random.nextInt(5);
            danhSach.add(taoHinhNgauNhien(loai));
        }
        return danhSach;
    }

    private static Shape taoHinhNgauNhien(int loai) {
        switch (loai) {
            case 0: { // Point
                double x = lamTron(randomDouble(-10, 10));
                double y = lamTron(randomDouble(-10, 10));
                return new Point(x, y);
            }
            case 1: { // Circle
                double x = lamTron(randomDouble(-10, 10));
                double y = lamTron(randomDouble(-10, 10));
                double r = lamTron(randomDouble(1, 10));
                return new Circle(new Point(x, y), r);
            }
            case 2: { // Line
                double x1 = lamTron(randomDouble(-10, 10));
                double y1 = lamTron(randomDouble(-10, 10));
                double x2 = lamTron(randomDouble(-10, 10));
                double y2 = lamTron(randomDouble(-10, 10));
                return new Line(new Point(x1, y1), new Point(x2, y2));
            }
            case 3: { // Triangle
                double x1 = lamTron(randomDouble(-8, 8));
                double y1 = lamTron(randomDouble(-8, 8));
                double x2 = lamTron(x1 + randomDouble(2, 8));
                double y2 = lamTron(y1);
                double x3 = lamTron(x1 + randomDouble(0, 6));
                double y3 = lamTron(y1 + randomDouble(2, 8));
                return new Triangle(new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
            }
            case 4: default: { // Rectangle
                double x = lamTron(randomDouble(-10, 10));
                double y = lamTron(randomDouble(-10, 10));
                double w = lamTron(randomDouble(2, 12));
                double h = lamTron(randomDouble(2, 10));
                return new Rectangle(new Point(x, y), w, h);
            }
        }
    }

    private static double randomDouble(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    private static double lamTron(double val) {
        return Math.round(val * 100.0) / 100.0;
    }

    // ==================== 2. HIỂN THỊ DANH SÁCH ====================

    /**
     * Hiển thị danh sách các hình với bảng định dạng chi tiết.
     */
    public static void hienThiDanhSach(List<Shape> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) {
            System.out.println("Danh sach trong.");
            return;
        }

        System.out.println("+-----+-----------+-------------------------------------------------------------+-----------------------+----------+-----------+");
        System.out.printf("| %-3s | %-9s | %-59s | %-21s | %-8s | %-9s |%n",
                "STT", "Loai Hinh", "Thong Tin Chi Tiet", "Tam/Trong Tam", "Chu Vi", "Dien Tich");
        System.out.println("+-----+-----------+-------------------------------------------------------------+-----------------------+----------+-----------+");

        for (int i = 0; i < danhSach.size(); i++) {
            Shape s = danhSach.get(i);
            String detail = s.toString();
            // Cắt ngắn nếu chuỗi chi tiết quá dài để vừa bảng
            if (detail.length() > 59) {
                detail = detail.substring(0, 56) + "...";
            }
            String centerStr = (s.getCenter() != null) ? s.getCenter().toString() : "N/A";
            System.out.printf("| %3d | %-9s | %-59s | %-21s | %8.2f | %9.2f |%n",
                    (i + 1), s.getName(), detail, centerStr, s.perimeter(), s.area());
        }
        System.out.println("+-----+-----------+-------------------------------------------------------------+-----------------------+----------+-----------+");
    }

    // ==================== 3. TÍNH TỔNG CHU VI & DIỆN TÍCH ====================

    public static double tinhTongChuVi(List<Shape> danhSach) {
        if (danhSach == null) return 0.0;
        double sum = 0.0;
        for (Shape s : danhSach) {
            sum += s.perimeter();
        }
        return sum;
    }

    public static double tinhTongDienTich(List<Shape> danhSach) {
        if (danhSach == null) return 0.0;
        double sum = 0.0;
        for (Shape s : danhSach) {
            sum += s.area();
        }
        return sum;
    }

    // ==================== 4. TÌM DIỆN TÍCH LỚN NHẤT / NHỎ NHẤT ====================

    public static Shape timHinhDienTichLonNhat(List<Shape> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) return null;
        Shape maxShape = danhSach.get(0);
        for (Shape s : danhSach) {
            if (s.area() > maxShape.area()) {
                maxShape = s;
            }
        }
        return maxShape;
    }

    public static void timVaInHinhDienTichLonNhat(List<Shape> danhSach) {
        Shape maxShape = timHinhDienTichLonNhat(danhSach);
        if (maxShape == null) {
            System.out.println("Danh sach trong.");
            return;
        }
        System.out.printf(" -> Hinh co dien tich LON NHAT : %s%n", maxShape.getName());
        System.out.printf("    Chi tiet: %s%n", maxShape);
        System.out.printf("    Dien tich: %.2f | Chu vi: %.2f%n", maxShape.area(), maxShape.perimeter());
    }

    public static Shape timHinhDienTichNhoNhat(List<Shape> danhSach) {
        if (danhSach == null || danhSach.isEmpty()) return null;
        Shape minShape = danhSach.get(0);
        for (Shape s : danhSach) {
            if (s.area() < minShape.area()) {
                minShape = s;
            }
        }
        return minShape;
    }

    public static void timVaInHinhDienTichNhoNhat(List<Shape> danhSach) {
        Shape minShape = timHinhDienTichNhoNhat(danhSach);
        if (minShape == null) {
            System.out.println("Danh sach trong.");
            return;
        }
        System.out.printf(" -> Hinh co dien tich NHO NHAT: %s%n", minShape.getName());
        System.out.printf("    Chi tiet: %s%n", minShape);
        System.out.printf("    Dien tich: %.2f | Chu vi: %.2f%n", minShape.area(), minShape.perimeter());

        // Tìm thêm hình có diện tích > 0 nhỏ nhất (nếu có Point hoặc Line diện tích = 0)
        Shape minPositive = null;
        for (Shape s : danhSach) {
            if (s.area() > 1e-6) {
                if (minPositive == null || s.area() < minPositive.area()) {
                    minPositive = s;
                }
            }
        }
        if (minPositive != null && minPositive != minShape) {
            System.out.printf("    (Hinh co dien tich duong > 0 nho nhat: %s, S = %.2f)%n",
                    minPositive.getName(), minPositive.area());
        }
    }

    // ==================== 5. BIẾN ĐỔI: ZOOM, MOVE, ROTATE ====================

    /**
     * Phóng to các hình trong danh sách với tỉ lệ ratio.
     */
    public static void phongToDanhSach(List<Shape> danhSach, double ratio) {
        if (danhSach == null || ratio <= 0) return;
        for (Shape s : danhSach) {
            s.zoom(ratio);
        }
    }

    /**
     * Tịnh tiến toàn bộ các hình theo vector (dx, dy).
     */
    public static void tinhTienDanhSach(List<Shape> danhSach, double dx, double dy) {
        if (danhSach == null) return;
        for (Shape s : danhSach) {
            s.move(dx, dy);
        }
    }

    /**
     * Xoay toàn bộ các hình quanh tâm một góc angle (độ).
     */
    public static void xoayDanhSach(List<Shape> danhSach, double angle) {
        if (danhSach == null) return;
        for (Shape s : danhSach) {
            s.rotate(angle);
        }
    }

    private static void tinhKhoangCachGiuaHaiHinh(List<Shape> danhSach, Scanner sc) {
        if (danhSach == null || danhSach.size() < 2) {
            System.out.println("Can it nhat 2 hinh de tinh khoang cach.");
            return;
        }
        System.out.printf("Nhap chi so hinh thu nhat (1 den %d): ", danhSach.size());
        try {
            int idx1 = Integer.parseInt(sc.nextLine().trim()) - 1;
            System.out.printf("Nhap chi so hinh thu hai (1 den %d): ", danhSach.size());
            int idx2 = Integer.parseInt(sc.nextLine().trim()) - 1;

            if (idx1 >= 0 && idx1 < danhSach.size() && idx2 >= 0 && idx2 < danhSach.size()) {
                Shape s1 = danhSach.get(idx1);
                Shape s2 = danhSach.get(idx2);
                double d = s1.distance(s2);
                System.out.printf("Khoang cach giua [Hinh %d: %s] va [Hinh %d: %s] la: %.2f%n",
                        (idx1 + 1), s1.getName(), (idx2 + 1), s2.getName(), d);
                System.out.printf(" (Tam hinh 1: %s, Tam hinh 2: %s)%n", s1.getCenter(), s2.getCenter());
            } else {
                System.out.println("Chi so hinh nam ngoai pham vi.");
            }
        } catch (Exception e) {
            System.out.println("Chi so khong hop le.");
        }
    }
}

