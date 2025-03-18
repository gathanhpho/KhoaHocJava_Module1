package ktCuoiModule1.phan3;

import java.util.Scanner;

/*
Câu 1 Viết chương trình nhận một chuỗi từ người dùng và in ra chuỗi đó theo chiều đảo ngược.
Hãy sử dụng StringBuilder hoặc StringBuffer để thực hiện thao tác này.
· Nhập vào một chuỗi.
· Sử dụng StringBuilder hoặc StringBuffer để đảo ngược chuỗi và in kết quả.
*/

public class Cau1 {
    public static void main(String[] args) {
        String input = nhapChuoi("Nhập vào 1 chuỗi: ");

        StringBuffer ketQua = daoNguocChuoi(input);

        System.out.println("Kết quả đảo ngược: " + ketQua);
    }

    public static String nhapChuoi(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        String chuoi;
        chuoi = sc.nextLine();
        return chuoi;
    }

    public static StringBuffer daoNguocChuoi(String input) {
        StringBuffer sb = new StringBuffer(input);
        if (sb.isEmpty() || sb.length() <= 1) {
            return sb;
        }

        for (int i = 0; i < sb.length() / 2; i++) {
            int left = i;
            int right = sb.length() - 1 - i;

            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
        }

        return sb;
    }
}
