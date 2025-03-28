package buoi10.btvn;

import java.util.Scanner;

public class KySu extends NhanVien {
    private String chuyenMon;


    public KySu(String maNV, String hoTen, int tuoi, double luongCoBan, String chuyenMon) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.chuyenMon = chuyenMon;
    }

    public KySu() {

    }

    @Override
    public double tinhLuong() {
        return luongCoBan + 2000000;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập chuyên môn: ");
        chuyenMon = sc.nextLine();
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Chuyên môn: " + chuyenMon);
    }
}
