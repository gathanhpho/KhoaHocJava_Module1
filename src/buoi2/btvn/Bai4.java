package buoi2.btvn;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Tính điểm sinh viên");
        System.out.println("2. Kiểm tra loại tam giác");
        System.out.println("3. Tính tiền điện");
        System.out.println("4. Kết thúc");

        System.out.print("Chọn chức năng: ");
        int so = sc.nextInt();

        switch (so) {
            case 1:
                Bai1.main(args);
                break;
            case 2:
                Bai2.main(args);
                break;
            case 3:
                Bai3.main(args);
                break;
            case 4:
                System.out.println("Chương trình kết thúc. Tạm biệt!");
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
    }
}
