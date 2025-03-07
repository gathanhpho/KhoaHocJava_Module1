package buoi2.bt;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        System.out.print("Nhập chiều dài: ");
        int chieuDai = new Scanner(System.in).nextInt();

        System.out.print("Nhập chiều rộng: ");
        int chieuRong = new Scanner(System.in).nextInt();

        int dienTich = chieuDai * chieuRong;
        System.out.println("Diện tích hình chữ nhật là: " + dienTich);
    }
}
