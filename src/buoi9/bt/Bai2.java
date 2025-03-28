package buoi9.bt;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Nhập số chia (a): ");
            try {
                a = sc.nextInt();
                validInput = true;
            }catch (Exception e) {
                System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                sc.nextLine();
            }
        }


    }
}
