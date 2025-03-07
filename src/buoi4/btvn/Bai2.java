package buoi4.btvn;

import java.util.Scanner;
import java.util.regex.*;

public class Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số điện thoại từ bàn phím
        System.out.print("Nhập số điện thoại: ");
        String soDienThoai = scanner.nextLine();

        // Kiểm tra số điện thoại hợp lệ hay không
        System.out.println((kiemTraSoDienThoai(soDienThoai) ? "Hợp lệ" : "Không hợp lệ"));

        scanner.close();
    }

    public static boolean kiemTraSoDienThoai(String s) {
        // Biểu thức chính quy kiểm tra số điện thoại hợp lệ
        String regex = "^(\\+84|0)\\d{9}$|^0\\d{2}([-.]\\d{3}){2}$";

        // So khớp với regex
        return Pattern.matches(regex, s);

    }
}

