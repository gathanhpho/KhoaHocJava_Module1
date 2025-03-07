package buoi4.bt;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập độ dài mảng: ");
        int num = sc.nextInt();
        int[] n = new int[num];

        for (int i = 0; i < n.length; i++) {
            System.out.print("Nhập số tự nhiên " + (i + 1) + ": ");
            n[i] = sc.nextInt();
            System.out.println(String.format("n%d = %s", i, n[i]));
        }

        System.out.println("Tổng: " + tong(n));
        System.out.println("Số lớn nhất: " + max(n));
        System.out.println("Số nhỏ nhất: " + min(n));


    }
    public static int tong(int[] n){
        int tong = 0;
        for (int i = 0; i < n.length; i++) {
            tong += n[i];
        }
        return tong;
    }
    public static int max(int[] n){
        int max = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[j] > n[i]) {
                    max = n[j];
                }
            }
        }
        return max;
    }
    public static int min(int[] n){
        int min = 0;
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                if (n[i] > n[j]) {
                    min = n[j];
                }
            }
        }
        return min;
    }
}
