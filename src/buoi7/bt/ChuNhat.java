package buoi7.bt;

public class ChuNhat extends DaGiac {
    private int chieuDai;
    private int chieuRong;

    public void dienTichCN(int chieuDai, int chieuRong) {
        int dienTich = this.chieuDai * this.chieuRong;
        System.out.println("Diện tích chiều dài " + dienTich);
    }

    public int getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(int chieuRong) {
        this.chieuRong = chieuRong;
    }

    public int getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(int chieuDai) {
        this.chieuDai = chieuDai;
    }
}
