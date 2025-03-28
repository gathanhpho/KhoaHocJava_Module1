package buoi10.bt.bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = new ArrayList<Person>();

        persons.add(new Person(1, "huy"));
        persons.add(new Person(2, "hoang"));
        persons.add(new Person(3, "hiep"));
        persons.add(new Person(4, "hieu"));

        System.out.println("Danh sach: ");
        persons.forEach(person -> {
            person.getInfo();
        });

        System.out.print("Nhập vào tên:");
        String name = new Scanner(System.in).nextLine();

        persons.stream().filter(person -> person.getName().equals(name)).forEach(person -> person.getInfo());
    }
}
