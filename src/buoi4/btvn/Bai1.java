package buoi4.btvn;

import java.util.*;

public class Bai1 {
    public static void main(String[] args) {
        String text = "Ngôn ngữ lập trình Java ban đầu được phát triển bởi Sun Microsystems do James Gosling khởi xướng và phát hành vào năm 1995. " +
                "Phiên bản mới nhất của Java Standard Edition là Java SE 8. Với sự tiến bộ của Java và sự phổ biến rộng rãi của nó, nhiều cấu hình đã được xây dựng để phù hợp với nhiều loại nền tảng khác nhau. " +
                "Ví dụ: J2EE cho các ứng dụng doanh nghiệp, " +
                "J2ME cho các ứng dụng di động.";

        // Đếm số lượng từng từ
        soLuongTu(text);

        // Viết hoa chữ cái đầu trong mỗi từ
        String vietHoaChuCaiDau = vietHoaChuCaiDau(text);
        System.out.println("Viết hoa chữ cái đầu: " + vietHoaChuCaiDau);

        // Xóa nguyên âm trong câu
        String xoaNguyenAm = xoaNguyenAm(text);
        System.out.println("Xóa nguyên âm: " + xoaNguyenAm);
    }

    public static void soLuongTu(String text) {
        // Loại bỏ dấu câu và chuyển thành chữ thường
        String[] words = text.toLowerCase().replaceAll("[,.:]", "").split("\\s+");
        List<String> checkedWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            if (!words[i].isEmpty() && !checkedWords.contains(words[i])) { // Bỏ qua từ trống
                int count = 0;
                for (int j = 0; j < words.length; j++) {
                    if (words[i].equals(words[j])) {
                        count++;
                    }
                }
                checkedWords.add(words[i]); // Đánh dấu từ đã kiểm tra
                System.out.println(words[i] + ": " + count);
            }
        }
    }

    public static String vietHoaChuCaiDau(String text) {
        StringBuilder result = new StringBuilder();
        String[] words = text.split("\\s+");
        for (String word : words) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }
        return result.toString().trim();
    }

    public static String xoaNguyenAm(String text) {
        return text.replaceAll("[aeiouAEIOU]", "");
    }
}

