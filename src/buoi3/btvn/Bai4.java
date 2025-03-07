package buoi3.btvn;

public class Bai4 {
    public static void main(String[] args) {
        int tongTien = 200000;
        int soPuongAn = 0;

        for (int x1 = 0; x1 <= tongTien / 1000; x1++) {
            for (int x2 = 0; x2 <= tongTien / 2000; x2++) {
                for (int x3 = 0; x3 <= tongTien / 5000; x3++) {
                    if (x1 * 1000 + x2 * 2000 + x3 * 5000 == tongTien) {
                        System.out.println("(x1 = " + x1 + ", x2 = " + x2 + ", x3 = " + x3 + ")");
                        soPuongAn++;
                    }
                }
            }
        }
        System.out.println("Tổng số các phương án là: " + soPuongAn);
    }
}