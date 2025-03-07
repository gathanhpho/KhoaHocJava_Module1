package buoi2.btvn;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số điện sử dụng trong tháng: ");
        int soDien = sc.nextInt();

        int soTien = tinhTienDien(soDien);
        System.out.println("Tiền điện cần thanh toán: " + String.format("%,d", soTien) + " VNĐ");
    }

    public static int tinhTienDien(int soDien) {
        int tongTien = 0;

        if (soDien <= 50) {
            tongTien = soDien * 1678;
        } else if (soDien <= 100) {
            tongTien = (50 * 1678) + ((soDien - 50) * 1734);
        } else if (soDien <= 200) {
            tongTien = (50 * 1678) + (50 * 1734) + ((soDien - 100) * 2014);
        } else if (soDien <= 300) {
            tongTien = (50 * 1678) + (50 * 1734) + (100 * 2014) + ((soDien - 200) * 2536);
        } else if (soDien <= 400) {
            tongTien = (50 * 1678) + (50 * 1734) + (100 * 2014) + (100 * 2536) + ((soDien - 300) * 2834);
        } else {
            tongTien = (50 * 1678) + (50 * 1734) + (100 * 2014) + (100 * 2536) + (100 * 2834) + ((soDien - 400) * 2927);
        }

        return tongTien;
    }
}