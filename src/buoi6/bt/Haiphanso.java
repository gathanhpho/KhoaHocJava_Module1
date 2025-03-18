package buoi6.bt;

import java.util.Scanner;

public class Haiphanso {
    Scanner sc = new Scanner(System.in);
    private int tuSo;
    private int tuSo1;
    private int mauSo;
    private int mauSo1;

    public void setTuSo() {
        this.tuSo = tuSo;
        System.out.print("nhập tử số thứ 1: ");
        tuSo = sc.nextInt();
    }

    public void setTuSo1() {
        this.tuSo1 = tuSo1;
        System.out.print("nhập tử số thứ 2: ");
        tuSo1 = sc.nextInt();
    }

    public void setMauSo() {
        this.mauSo = mauSo;
        System.out.print("nhập mẫu số thứ 1: ");
        mauSo = sc.nextInt();
    }
    public void setMauSo1() {
        this.mauSo1 = mauSo1;
        System.out.print("nhập mẫu số thứ 2: ");
        mauSo1 = sc.nextInt();
    }

    public void getPhanSo1() {
        System.out.println("Phân số thứ 1: " + tuSo + "/" +mauSo);
    }
    public void getPhanSo2() {
        System.out.println("tử số thứ 2:" + tuSo1 + "/" + mauSo1);
    }

    public void tongTu(int tuSo, int mauSo, int tuSo1, int mauSo1) {
        int tongTuSo = (tuSo * mauSo1) + (tuSo1 * mauSo);
        int tongMauSo = (mauSo * mauSo1) + (mauSo1 * mauSo);
        System.out.println("Tổng hai số: " + tongTuSo + "/" + tongMauSo);
    }

}

