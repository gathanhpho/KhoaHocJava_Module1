package buoi8.btvn;

import java.util.Scanner;

public abstract class Book {
    private int id;
    private String title;
    private int year;
    private String author;

    public void displayInfo(){
        System.out.println("id: " + id);
        System.out.println("title: " + title);
        System.out.println("year: " + year);
        System.out.println("author: " + author);
    }

    public void inputInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập id: ");
        id = sc.nextInt();
        System.out.print("Nhập title: ");
        title = sc.next();
        System.out.print("Nhập year: ");
        year = sc.nextInt();
        System.out.print("Nhập author: ");
        author = sc.next();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
