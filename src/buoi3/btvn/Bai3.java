package buoi3.btvn;

import java.util.Scanner;

/*
Bài 3: Tính giai thừa của n (n!)
Mô tả: Nhập vào số nguyên dương n, tính giai thừa của n.
Test Case:
1. Input: n = 5 Output: 5! = 5 * 4 * 3 * 2 * 1 = 120
2. Input: n = 7
Output: 7! = 7 * 6 * 5 * 4 * 3 * 2 * 1 = 5040
*/
public class Bai3 {
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

        int giaiThua = 1;
        for (int i = 1; i <= n; i++) {
            giaiThua *= i;
        }
        System.out.println("Giai thừa của " + n + "! là: " + giaiThua);
    }
}
