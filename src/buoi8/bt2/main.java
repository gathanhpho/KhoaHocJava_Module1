package buoi8.bt2;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập vào số a: ");
        int soA = sc.nextInt();

        System.out.print("Nhập vào số b: ");
        int SoB = sc.nextInt();

        IChiaHaiSo chiaHaiSo = new ChiaHaiSo(){
            @Override
            public int chiaHaiSo(int a, int b) {
                return a / b;
            }
        };
        System.out.println("thương 2 số: " + chiaHaiSo.chiaHaiSo(soA, SoB));

        IChiaHaiSo chiaHaiSo2 = ( a,  b) -> a / b;
        System.out.println("thương 2 số: " + chiaHaiSo2.chiaHaiSo(soA, SoB));
    }
}
