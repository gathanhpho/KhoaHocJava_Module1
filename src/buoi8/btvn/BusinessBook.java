package buoi8.btvn;

import java.util.Scanner;

public class BusinessBook extends Book {
    private String businessField;

    @Override
    public void displayInfo(){
        super.displayInfo();
        System.out.println("Lĩnh vực: " + businessField);
    }

    @Override
    public void inputInfo(){
        Scanner sc = new Scanner(System.in);

        super.inputInfo();
        System.out.println("Nhập lĩnh vực: ");
        businessField = sc.nextLine();
    }

    public String getBusinessField() {
        return businessField;
    }

    public void setBusinessField(String businessBook) {
        businessField = businessBook;
    }
}
