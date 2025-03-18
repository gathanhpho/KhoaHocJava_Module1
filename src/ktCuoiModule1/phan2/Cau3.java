package ktCuoiModule1.phan2;

import java.util.Scanner;

/*
Câu 3 Viết một chương trình tính tiền vé xe bus theo số chuyến đi của người dùng. Cấu trúc giá vé như sau:
· Mỗi chuyến đi có giá 10.000 VNĐ.
· Nếu người dùng đi trên 5 chuyến, áp dụng giảm giá 10%.
· Nếu đi trên 10 chuyến, áp dụng giảm giá 20%.
Chương trình cần nhập vào số chuyến đi và in ra số tiền phải trả sau khi áp dụng giảm giá.
Yêu cầu:
1. Nhập vào số chuyến đi.
2. Áp dụng giảm giá nếu số chuyến đi vượt qua các mức quy định.
3. In ra số tiền phải trả.
*/
public class Cau3 {
    public static void main(String[] args) {

        int soChuyenDi = nhapSoChuyenDi();

        double soTienPhaiTra = tinhTienVe(soChuyenDi);

        System.out.printf("Số tiền phải trả sau khi áp dụng giảm giá: %,.0f VNĐ", soTienPhaiTra);
    }

    public static double tinhTienVe(int soChuyen) {
        double giaVe = 10000;
        double tongTien = soChuyen * giaVe;
        double tiLeGiamGia = 0;

        if (soChuyen > 10) {
            tiLeGiamGia = 0.2;
        } else if (soChuyen > 5) {
            tiLeGiamGia = 0.1;
        }

        double soTienGiam = tongTien * tiLeGiamGia;
        return tongTien - soTienGiam;
    }

    public static int nhapSoChuyenDi() {
        Scanner sc = new Scanner(System.in);
        int soChuyen;
        do {
            System.out.print("Nhập số chuyến đi số nguyên dương: ");
            soChuyen = sc.nextInt();
            if (soChuyen <= 0) {
                System.out.println("Số chuyến đi phải là số nguyên dương. Vui lòng nhập lại!");
            }
        } while (soChuyen <= 0);
        return soChuyen;
    }
}
