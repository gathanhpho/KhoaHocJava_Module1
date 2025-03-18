package ktCuoiModule1.phan2;

import java.util.Scanner;

/*
Câu 2: Viết chương trình nhập vào một số nguyên từ 1 đến 7 đại diện cho một ngày
 trong tuần và in ra tên của ngày đó (1 - "Chủ nhật", 2 - "Thứ hai", ..., 7 - "Thứ bảy").
 Chương trình phải sử dụng cấu trúc switch-case để thực hiện.
1. Nhập vào số nguyên từ 1 đến 7.
2. Dùng switch-case để in ra tên của ngày tuần tương ứng.
*/

public class Cau2 {

    public static void main(String[] args) {
        int n = nhapSo1Den7("Nhập số từ 1 đến 7 để hiện số ngày tương ứng: ");

        ngaySo1Den7(n);
    }

    public static void ngaySo1Den7(int n) {
        switch (n) {
            case 1:
                System.out.println(n + " là Chủ nhật");
                break;
            case 2:
                System.out.println(n + " là Thứ hai");
                break;
            case 3:
                System.out.println(n + " là Thứ ba");
                break;
            case 4:
                System.out.println(n + " là Thứ tư");
                break;
            case 5:
                System.out.println(n + " là Thứ năm");
                break;
            case 6:
                System.out.println(n + " là Thứ sáu");
                break;
            case 7:
                System.out.println(n + " là Thứ bảy");
                break;
        }
    }

    public static int nhapSo1Den7(String text) {
        Scanner sc = new Scanner(System.in);
        int n;
        do {
            System.out.print(text);
            n = sc.nextInt();
            if (n < 1 || n > 7) {
                System.out.println("Vui lòng chỉ nhập số từ 1 đến 7!");
            }
        } while (n < 1 || n > 7);
        return n;
    }
}
