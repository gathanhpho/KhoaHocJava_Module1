package buoi7.bt;

public class HinhVuong extends ChuNhat {
    private int a;

    public void gocHV(int a) {
        System.out.println("Hinh vuong luôn có 4 góc = " + a);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
