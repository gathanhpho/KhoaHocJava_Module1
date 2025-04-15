package ktCuoiModule2;

public class Employee implements Workable {
    private String name;
    private int age;
    private double salary;

    public Employee() {}

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
        if (!(this instanceof Manager)) {
            work();
        };
    }

    public void updateSalary(Employee employee, double newSalary) {
        if (newSalary < 0) {
            throw new IllegalArgumentException("Lương ko đươc dưới 0");
        }
        employee.salary = newSalary;
    }

    @Override
    public void work() {
        System.out.println("Working as an employee");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
