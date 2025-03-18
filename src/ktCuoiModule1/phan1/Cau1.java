package ktCuoiModule1.phan1;

import java.util.Scanner;

/*
Câu 1 Viết chương trình nhập vào hai số nguyên từ người dùng và tính tổng của chúng. Sau đó in ra kết quả.
Yêu cầu:
1. Nhập vào hai số nguyên từ bàn phím.
2. In ra kết quả tổng của hai số.
*/
public class Cau1 {
    public static void main(String[] args) {
        System.out.println("Nhập vào 2 số nguyên ");

        int a = nhapSoNguyen("Nhập vào số nguyên 1: ");
        int b = nhapSoNguyen("Nhập vào số nguyên 2: ");

        System.out.println("Tổng của 2 số nguyên là: " + tong(a,b));

    }

    public static int tong (int a, int b) {
        int tong = a + b;
        return tong;
    }

    public static int nhapSoNguyen(String text) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print(text);
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Vui lòng nhập lại số nguyên!");
            }
        } while (n < 0);
        return n;
    }
}
