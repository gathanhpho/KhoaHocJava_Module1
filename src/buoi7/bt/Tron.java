package buoi7.bt;

public class Tron extends Hinh {
    private String mau;

    public void mauTG(String mau) {
        System.out.println("Máu hình tam giác: " + mau);
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }
}
