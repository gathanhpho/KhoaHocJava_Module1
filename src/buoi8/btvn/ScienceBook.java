package buoi8.btvn;

import java.util.Scanner;

public class ScienceBook extends Book{
    private String researchSubject;

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Đối tượng nghiên cứu: " + researchSubject);
    }

    @Override
    public void inputInfo(){
        Scanner sc = new Scanner(System.in);

        super.inputInfo();
        System.out.println("Nhập đối tượng nghiên cứu: ");
        researchSubject = sc.nextLine();
    }

    public String getResearchSubject() {
        return researchSubject;
    }

    public void setResearchSubject(String researchSubject) {
        this.researchSubject = researchSubject;
    }
}
