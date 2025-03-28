package buoi9.bt;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getInts(scanner);

        extracted(numbers);

        scanner.close();
    }

    private static int[] getInts(Scanner scanner) {
        int[] numbers = new int[5];

        for (int i = 0; i < 5; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Nhập số thứ " + (i + 1) + ": ");
                try {
                    numbers[i] = scanner.nextInt();
                    validInput = true;
                } catch (Exception e) {
                    System.out.println("Lỗi: Vui lòng nhập một số hợp lệ!");
                    scanner.nextLine();
                }
            }
        }
        return numbers;
    }

    private static void extracted(int[] numbers) {
        System.out.println("\nCác số đã nhập là:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Số " + (i + 1) + ": " + numbers[i]);
        }
    }
}
