package buoi10.btvn;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyImpl quanLy = new QuanLyImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== QUẢN LÝ NHÂN SỰ ===");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Hiển thị danh sách nhân viên");
            System.out.println("3. Tính tổng lương công ty");
            System.out.println("4. Tìm nhân viên lương cao nhất");
            System.out.println("5. Tìm nhân viên theo mã");
            System.out.println("6. Sắp xếp theo tên (A-Z)");
            System.out.println("7. Sắp xếp theo lương (giảm dần)");
            System.out.println("8. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1: quanLy.themNhanVien(); break;
                case 2: quanLy.hienThiDanhSach(); break;
                case 3: System.out.println("Tổng lương: " + quanLy.tinhTongLuong()); break;
                case 4: quanLy.timLuongCaoNhat(); break;
                case 5:
                    System.out.print("Nhập mã NV cần tìm: ");
                    String maNV = sc.nextLine();
                    quanLy.timTheoMaNV(maNV);
                    break;
                case 6: quanLy.sapXepTheoTen(); break;
                case 7: quanLy.sapXepTheoLuongGiamDan(); break;
                case 8: System.out.println("Thoát chương trình!"); return;
                default: System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
}
