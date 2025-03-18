package ktCuoiModule1.phan1;

/*
Câu 2 Viết một chương trình tính diện tích của một hình tròn từ bán kính nhập vào từ người dùng. Sau đó, in ra kết quả và kiểm tra xem diện tích có phải là số chẵn hay số lẻ.
Sử dụng các phép toán với kiểu dữ liệu double và int để tính diện tích.
Yêu cầu:
1. Nhập vào bán kính hình tròn.
2. Tính diện tích hình tròn.
3. Kiểm tra diện tích là chẵn hay lẻ và in kết quả.
*/

import java.util.Scanner;

public class Cau2 {
    public static void main(String[] args) {
        int r = nhapBanKinhHT("Nhập vào bán kính hình tròn: ");

        double ketQua = dienTich(r);

        System.out.println("Diện tích hình tròn là:" + ketQua);
        soChanLe(ketQua);
    }

    public static void soChanLe(double a) {
        if (a % 2 == 0) {
            System.out.println(a + " là sỗ chẵn");
        } else {
            System.out.println(a + " là sỗ lẻ");
        }
    }

    public static double dienTich(int r) {
        double dienTich;
        dienTich = 3.14 * (r * r);
        return dienTich;
    }

    public static int nhapBanKinhHT(String text) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print(text);
            n = sc.nextInt();
            if (n < 0) {
                System.out.println("Vui lòng nhập lại số nguyên!");
            }
        } while (n <= 0);
        return n;
    }
}
