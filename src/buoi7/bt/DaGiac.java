package buoi7.bt;

public class DaGiac extends Hinh {
    private int canh;

    public void soCanh() {
        System.out.println("Số cạnh của hình" + canh);
    }

    public int getCanh() {
        return canh;
    }

    public void setCanh(int canh) {
        this.canh = canh;
    }
}
