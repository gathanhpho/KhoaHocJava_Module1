package buoi7.btvn;

import java.util.Scanner;

public class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String species, String color, String breed) {
        super(name, age, species, color);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Woof! Woo");
    }

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        super.inputInfo();
        System.out.print("Nhập gióng chó");
        breed = sc.nextLine();
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Breed: " + breed);
    }
}
