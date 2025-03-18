package buoi6.bt;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            Dongvat dongVat = new Dongvat();
            dongVat.tenDV = "Tên động vật:" + i;
            dongVat.soChan = 4;

            dongVat.ten();
        }
    }
}
