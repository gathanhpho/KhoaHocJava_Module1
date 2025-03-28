package buoi10.btvn;

import java.util.Scanner;

public abstract class NhanVien {
    private String maNV;
    private String hoTen;
    private int tuoi;
    protected double luongCoBan;

    public NhanVien(String maNV, String hoTen, int tuoi, double luongCoBan) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.luongCoBan = luongCoBan;
    }

    public NhanVien() {

    }

    public abstract double tinhLuong();

    public void hienThiThongTin(){
        System.out.println("Mã NV: " + maNV);
        System.out.println("HoTen: " + hoTen);
        System.out.println("Tuoi: " + tuoi);
        System.out.println("Luong Co Ban: " + luongCoBan);
    };

    public void nhapThongTin(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập NV: ");
        maNV = sc.nextLine();
        System.out.print("HoTen: ");
        hoTen = sc.nextLine();
        System.out.print("Tuoi: ");
        tuoi = sc.nextInt();
        System.out.print("Luong Co Ban: ");
        luongCoBan = sc.nextDouble();
    };

    public String getMaNV() {
        return maNV;
    }

    public String getHoTen() {
        return hoTen;
    }
}
