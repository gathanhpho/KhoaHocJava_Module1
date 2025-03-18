package buoi7.bt;

public class Hinh {
    private String hinh;

    public void tenHinh(String hinh) {
        System.out.println("--------------");
        System.out.println("Tên hình: " + hinh);
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }
}
