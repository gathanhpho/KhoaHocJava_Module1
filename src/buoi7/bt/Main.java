package buoi7.bt;

public class Main {
    public static void main(String[] args) {
        Hinh daGiac = new DaGiac();
        daGiac.tenHinh("Hinh");
        ((DaGiac) daGiac).soCanh();
    }
}
