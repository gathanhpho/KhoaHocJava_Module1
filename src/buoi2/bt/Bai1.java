package buoi2.bt;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        System.out.print("Nhập họ tên: ");
        String hoTen = new Scanner(System.in).nextLine();

        System.out.print("Nhập ngày sinh: ");
        int ngay = new Scanner(System.in).nextInt();

        System.out.print("Nhập tháng sinh: ");
        int thang = new Scanner(System.in).nextInt();

        System.out.print("Nhập năm sinh: ");
        int nam = new Scanner(System.in).nextInt();

        System.out.print("Nhập quê quán: ");
        String queQuan = new Scanner(System.in).nextLine();

        System.out.print("Nhập trường học: ");
        String truongHoc = new Scanner(System.in).nextLine();

        System.out.println("Xin chào " + hoTen + ", đến từ " + queQuan + ", sinh ngày"
                + ngay + "/" + thang + "/" + nam + ", học trường " + truongHoc);
    }
}