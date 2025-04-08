package buoi11.bt;

public class ThreadCumstom extends Thread {
    private int soBD;
    private int soKT;

    public ThreadCumstom(int soBD, int soKT) {
        this.soBD = soBD;
        this.soKT = soKT;
    }

    public void run() {
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
