package buoi7.btvn;

import java.util.Scanner;

public abstract class Animal {
    private String name;
    private int age;
    private String species;
    private String color;

    public Animal(String name, int age, String species, String color) {
        this.name = name;
        this.age = age;
        this.species = species;
        this.color = color;
    }

    public abstract void makeSound();

    public void inputInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên đông vật");
        name = sc.nextLine();
        System.out.print("Nhập tuổi động vật");
        age = sc.nextInt();
        System.out.print("Nhập loại động vật");
        species = sc.nextLine();
        System.out.print("Nhập màu động vật");
        color = sc.nextLine();
    }

    public void displayInfo() {
        System.out.println("Tên động vật: " + name);
        System.out.println("Tuổi động vật: " + age);
        System.out.println("Loại: " + species);
        System.out.println("Color: " + color);
    }
}
