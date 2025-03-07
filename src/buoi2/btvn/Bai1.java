package buoi2.btvn;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập điểm chuyên cần: ");
        float c = sc.nextFloat();
        System.out.print("Nhập điểm giữa kỳ: ");
        float b = sc.nextFloat();
        System.out.print("Nhập diểm cuối kỳ: ");
        float a = sc.nextFloat();

        float diemTB = c * 0.1f + b * 0.3f + a * 0.6f;
        System.out.println("Điểm trung bình là: " + String.format("%.1f", diemTB));

        if (diemTB >= 9) {
            System.out.println("Đạt loại A");
        } else if (diemTB >= 7 && diemTB < 9) {
            System.out.println("Đạt loại B");
        } else if (diemTB >= 5 && diemTB < 7) {
            System.out.println("Đạt loại C");
        } else {
            System.out.println("Đặt loại D");
        }

        sc.close();
    }
}