import java.util.Arrays;

public class Bai2 {

    public static void tinhTongMang(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            int x = (i < a.length) ? a[i] : 0;
            int y = (i < b.length) ? b[i] : 0;

            c[i] = x + y;
        }

        System.out.println("Mang tong: " + Arrays.toString(c));
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {5, 6, 7};

        tinhTongMang(a, b);
    }
}