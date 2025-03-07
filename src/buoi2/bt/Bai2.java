package buoi2.bt;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        System.out.print("Nhập số thứ nhất: ");
        int a = new Scanner(System.in).nextInt();

        System.out.print("Nhập số thứ hai: ");
        int b = new Scanner(System.in).nextInt();

        int tong = a + b;
        int tich = a * b;
        float thuong = (float) a / b;
        int thuongDu = a % b;

        System.out.println("Tổng: " + tong);
        System.out.println("Tích: " + tich);
        System.out.println("Thương: " + thuong);
        System.out.println("Thương dư: " + thuongDu);
    }
}