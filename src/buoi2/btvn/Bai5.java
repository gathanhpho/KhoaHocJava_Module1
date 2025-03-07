package buoi2.btvn;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập năm: ");
        int a = sc.nextInt();
        System.out.print("Nhập tháng: ");
        int b = sc.nextInt();

        // Xác định số ngày trong tháng
        int soNgay;
        switch (b) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                soNgay = 31;
                System.out.println("Tháng: " + b + ", Năm: " + a + ", Có số ngày là: " + soNgay);
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                soNgay = 30;
                System.out.println("Tháng: " + b + ", Năm: " + a + ", Có số ngày là: " + soNgay);
                break;
            case 2:
                if ((a % 400 == 0) || (a % 4 == 0 && a % 100 != 0)) {
                    soNgay = 29;
                    System.out.println("Tháng: " + b + ", Năm: " + a + ", Có số ngày là: " + soNgay);
                } else {
                    soNgay = 28;
                    System.out.println("Tháng: " + b + ", Năm: " + a + ", Có số ngày là: " + soNgay);
                }
                break;
            default:
                System.out.println("Tháng không hợp lệ!");
        }
    }
}