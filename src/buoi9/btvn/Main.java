package buoi9.btvn;

public class Main {
    public static void main(String[] args) {
        CourseManager manager = new CourseManager();

        // Khởi tạo 2 student mặc định
        Student student1 = new Student(1, "John Doe");
        Student student2 = new Student(2, "Jane Smith");

        manager.addStudent(student1);
        manager.addStudent(student2);

        // Thử đăng ký các môn học
        manager.registerStudentForCourse(student1, "Math");
        manager.registerStudentForCourse(student1, "English");
        manager.registerStudentForCourse(student1, "Math"); // Sẽ throw exception

        manager.registerStudentForCourse(student2, "Science");
        manager.registerStudentForCourse(student2, "History");

        // Hiển thị thông tin
        System.out.println("\nStudent Information:");
        student1.showInfo();
        student2.showInfo();
    }
}
