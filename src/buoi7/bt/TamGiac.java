package buoi7.bt;

public class TamGiac extends DaGiac {
    private int a;
    private int b;
    private int c;

    public void chuVi(int a, int b, int c) {
        int chuVi = this.a + this.b + this.c;
        System.out.println("Chu vi tam giác: " + chuVi);
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
