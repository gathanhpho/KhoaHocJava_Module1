package buoi10.bt.bai1;

public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void getInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }

    public String getName(){
        return name;
    }

}
