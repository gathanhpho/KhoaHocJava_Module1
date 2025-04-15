package buoi10.btvn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyImpl implements IQuanLy{
    private ArrayList<NhanVien> danhSachNhanVien;

    public QuanLyImpl() {
        danhSachNhanVien = new ArrayList<>();
        khoiTaoNhanVienMacDinh();
    }

    @Override
    public void QuanLyImpl(NhanVien NhanVien) {

    }

    @Override
    public void khoiTaoNhanVienMacDinh() {
        danhSachNhanVien.add(new NhanVienVanPhong("NV001", "Nguyễn Văn A", 30, 5000000, 20));
        danhSachNhanVien.add(new KySu("KS002", "Trần Thị B", 28, 7000000, "Công nghệ thông tin"));
        danhSachNhanVien.add(new QuanLy("QL003", "Lê Quang C", 35, 10000000, 1.5));
    }

    @Override
    public void themNhanVien() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Chọn loại nhân viên: 1 - Văn phòng, 2 - Kỹ sư, 3 - Quản lý");
        int choice = sc.nextInt();
        NhanVien nv = null;
        switch (choice) {
            case 1: nv = new NhanVienVanPhong(); break;
            case 2: nv = new KySu(); break;
            case 3: nv = new QuanLy(); break;
            default: System.out.println("Lựa chọn không hợp lệ!"); return;
        }
        nv.nhapThongTin();
        try {
            for (NhanVien n : danhSachNhanVien) {
                if (n.getMaNV().equals(nv.getMaNV())) {
                    throw new Exception("Mã nhân viên " + nv.getMaNV() + " đã tồn tại!");
                }
            }
            danhSachNhanVien.add(nv);
            System.out.println("Thêm nhân viên thành công!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void hienThiDanhSach() {
        for (NhanVien nv : danhSachNhanVien) {
            nv.hienThiThongTin();
            System.out.println("-------------------");
        }
    }

    @Override
    public double tinhTongLuong() {
        double tongLuong = 0;
        for (NhanVien nv : danhSachNhanVien) {
            tongLuong += nv.tinhLuong();
        }
        return tongLuong;
    }

    @Override
    public void timLuongCaoNhat() {
        danhSachNhanVien.stream()
                    .max(Comparator.comparingDouble(NhanVien::tinhLuong))
                .ifPresent(nv -> {
                    System.out.println("Nhân viên có lương cao nhất:");
                    nv.hienThiThongTin();
                });;
    }

    @Override
    public void timTheoMaNV(String maNV) {
        for (NhanVien nv : danhSachNhanVien) {
            if (nv.getMaNV().equals(maNV)) {
                nv.hienThiThongTin();
                return;
            }
        }
        System.out.println("Không tìm thấy nhân viên với mã " + maNV);
    }

    @Override
    public void sapXepTheoTen() {
        Collections.sort(danhSachNhanVien, Comparator.comparing(nv -> nv.getHoTen()));
        System.out.println("Danh sách đã được sắp xếp theo tên:");
        hienThiDanhSach();
    }

    @Override
    public void sapXepTheoLuongGiamDan() {
        System.out.println("Danh sách đã được sắp xếp theo lương giảm dần:");
        danhSachNhanVien.stream()
                .sorted(Comparator.comparingDouble(NhanVien::tinhLuong).reversed())
                .forEach(nv -> {
                    nv.hienThiThongTin();
                    System.out.println("-------------------");
                });
    }
}
