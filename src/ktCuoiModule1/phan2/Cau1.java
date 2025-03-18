package ktCuoiModule1.phan2;

import java.util.Scanner;
/*
Câu 1 Viết chương trình nhập vào một số nguyên từ người dùng và kiểm tra số đó là số chẵn hay số lẻ.
Chương trình cần in ra kết quả phù hợp. Hãy sử dụng cấu trúc điều kiện if-else để giải quyết.
Yêu cầu:
1. Nhập một số nguyên từ bàn phím.
2. Nếu số là chẵn, in ra "Số chẵn".
3. Nếu số là lẻ, in ra "Số lẻ".
*/

public class Cau1 {
    public static void main(String[] args) {
        int a = nhapSoNguyen("Nhập số nguyên: ");

        soChanLe(a);
    }

    public static void soChanLe(int a) {
        if (a % 2 == 0) {
            System.out.println(a + " là sỗ chẵn");
        } else {
            System.out.println(a + " là sỗ lẻ");
        }
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
