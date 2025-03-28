package buoi10.btvn;

import java.util.Scanner;

public class QuanLy extends NhanVien {
    private double heSoChucVu;

    public QuanLy(String maNV, String hoTen, int tuoi, double luongCoBan, double heSoChucVu) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.heSoChucVu = heSoChucVu;
    }

    public QuanLy() {

    }

    @Override
    public double tinhLuong() {
        return luongCoBan * heSoChucVu;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập hệ số chức vụ: ");
        heSoChucVu = sc.nextDouble();
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Hệ số chức vụ: " + heSoChucVu);
    }
}
