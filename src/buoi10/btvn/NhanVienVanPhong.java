package buoi10.btvn;

import java.util.Scanner;

public class NhanVienVanPhong extends NhanVien {
    private int soNgayLamViec;

    public NhanVienVanPhong(String maNV, String hoTen, int tuoi, double luongCoBan, int soNgayLamViec) {
        super(maNV, hoTen, tuoi, luongCoBan);
        this.soNgayLamViec = soNgayLamViec;
    }

    public NhanVienVanPhong() {

    }

    @Override
    public double tinhLuong() {
        return luongCoBan + soNgayLamViec * 100000;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số ngày làm việc: ");
        soNgayLamViec = sc.nextInt();
    }

    @Override
    public void hienThiThongTin() {
        super.hienThiThongTin();
        System.out.println("Số ngày làm việc: " + soNgayLamViec);
    }
}
