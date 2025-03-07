package buoi2.btvn;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập cạnh a: ");
        int a = sc.nextInt();
        System.out.print("Nhập cạnh b: ");
        int b = sc.nextInt();
        System.out.print("Nhập cạnh c: ");
        int c = sc.nextInt();

        if (a + b > c && a + c > b && b + c > a) {
            boolean tamGiacVuong = (a * a + b * b == c * c) ||
                    (a * a + c * c == b * b) ||
                    (b * b + c * c == a * a);
            boolean tamGiacCan = a == b || b == c || c == a;

            if (tamGiacVuong && tamGiacCan) {
                System.out.println("Tam giác vuông cân");
            } else if (tamGiacVuong) {
                System.out.println("Tam giác vuông");
            } else if (tamGiacCan) {
                System.out.println("Tam giác cân");
            } else if (a == b && b == c) {
                System.out.println("Tam giác đều");
            } else {
                System.out.println("Tam giác thường");
            }
        } else {
            System.out.println("Không phải tam giác");
        }
    }
}