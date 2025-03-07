package buoi3.btvn;

import java.util.Scanner;
/*
Bài 1: Tính tổng S(n) = 1^3 + 2^3 + 3^3 + ... + n^3
Mô tả: Nhập n từ bàn phím (n dương, bắt nhập lại nếu n âm) và tính tổng dãy S(n).
Test Case:
1. Input: n = 3 Output: S(3) = 1^3 + 2^3 + 3^3 = 1 + 8 + 27 = 36
2. Input: n = 5 Output: S(5) = 1^3 + 2^3 + 3^3 + 4^3 + 5^3 = 1 + 8 + 27 + 64 + 125 = 225
*/
public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.print("Nhập số dương: ");
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Vui lòng nhập lại số dương!");
            }
        } while (n < 0);

        int tong = 0;
        for (int i = 1; i <= n; i++) {
            tong += Math.pow(i, 3);
        }

        System.out.println("Tổng S(n) là: " + tong);
    }
}
