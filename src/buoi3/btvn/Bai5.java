package buoi3.btvn;

import java.util.Scanner;

/*
Bài 5: Đổi sang số nhị phân của một số nguyên dương n
Mô tả: Nhập vào số nguyên dương n và in ra số nhị phân của nó.
Test Case:
1. Input: n = 8 Output: 8 -> 1000
2. Input: n = 7 Output: 7 -> 111
3. Input: n = 9 Output: 9 -> 1001
4. Input: n = 16
Output: 16 -> 10000
*/

public class Bai5 {
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

        String binary = "";
        while (n > 0) {
            binary = (n % 2) + binary; // Thêm phần dư vào trước chuỗi
            n /= 2;
        }
        System.out.println("Số nhị phân của " + n + " là: " +  binary);
    }
}
