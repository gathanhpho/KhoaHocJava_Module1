package ktCuoiModule2;

public class Manager extends Employee implements Workable {
    private String department;

    public Manager() {}

    public Manager(String name, int age, double salary, String department) {
        super(name, age, salary);
        this.department = department;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Department: " + department);
        work();
    }

    public void displayInfo(String format) {
        if (format.equalsIgnoreCase("json")) {
            String jsonFormat = String.format(
                    "{\"name\": \"%s\", \"age\": \"%d\", \"salary\": \"%.2f\", \"department\": \"%s\"}",
                    getName(), getAge(), getSalary(), getDepartment());
            System.out.println(jsonFormat);
        } else if (format.equalsIgnoreCase("simple")) {
            System.out.println(getName() + " - " + getAge() + " - " + getSalary() + " - " + getDepartment());
        } else {
            System.out.println("Định dạng ko hợp lệ. Sử dụng định dang mặc định");
            displayInfo();
        }
    }

    @Override
    public void work() {
        System.out.println("Managing department: " + getDepartment());
    }

    public String getDepartment() {
        return department;
    }
}
