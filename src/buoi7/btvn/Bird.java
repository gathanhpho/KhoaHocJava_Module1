package buoi7.btvn;

public class Bird extends Animal {
    private int wingSpan;

    public Bird(String name, int age, String species, String color, int wingSpan) {
        super(name, age, species, color);
        this.wingSpan = wingSpan;
    }

    @Override
    public void makeSound() {
        System.out.println("Tweet! Twee");
    }

    public void inputInfo() {
        super.inputInfo();
        System.out.println("");
    }
}
