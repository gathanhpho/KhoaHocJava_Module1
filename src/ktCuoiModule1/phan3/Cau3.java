package ktCuoiModule1.phan3;

import java.util.Scanner;

/*
Câu 3 Viết chương trình nhập vào một chuỗi từ người dùng và kiểm tra xem chuỗi đó có phải là chuỗi Palindrome (chuỗi đối xứng) hay không.
Sử dụng StringBuilder
Yêu cầu:
1. Nhập vào một chuỗi.
2. Kiểm tra nếu chuỗi đó là Palindrome (đối xứng).
3. In ra kết quả: "Chuỗi là Palindrome" hoặc "Chuỗi không phải là Palindrome".
*/
public class Cau3 {
    public static void main(String[] args) {
        String input = nhapChuoi("Nhập 1 chuỗi: ");

        System.out.println("Chuỗi: \"" + input + "\"" + (isPalindrome(input) ? " là" : " không phải") +
                " Palindrome");
    }

    public static String nhapChuoi(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        String chuoi;
        chuoi = sc.nextLine();
        return chuoi;
    }

    public static boolean isPalindrome(String input) {
        StringBuffer sb = new StringBuffer(input);
        if (sb.isEmpty() || sb.length() <= 1) {
            return true;
        }

        for (int i = 0; i < sb.length() / 2; i++) {
            int left = i;
            int right = sb.length() - 1 - i;

            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
        }

        return input.equals(sb.toString());
    }
}
