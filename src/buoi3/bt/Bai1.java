package buoi3.bt;

import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soAm = 0;
        int soDuong = 0;

        int tongAm = 0;
        int tongDuong = 0;

        System.out.print("Nhập 10 số bất kỳ:");
        for ( int i = 0; i < 10; i++ ) {
            int a = sc.nextInt();
            if (a<0){
                soAm++;
                tongAm += a;
            } else {
                soDuong++;
                tongDuong += a;
            }
        }
        System.out.println("Có: "+ soAm + " sô âm," + " tổng số âm là: " + tongAm);
        System.out.println("Có: "+ soDuong + " sô dương," + " tổng số dương là: " + tongDuong);

    }
}
