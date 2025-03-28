package buoi9.btvn;

public class CourseManager {
    private Student[] students;
    private int numberCurrentStudent;

    public CourseManager() {
        this.students = new Student[10];
        this.numberCurrentStudent = 0;
    }

    public void addStudent(Student student) {
        if (numberCurrentStudent >= students.length) {
            students = java.util.Arrays.copyOf(students, students.length * 2);
        }
        students[numberCurrentStudent++] = student;
    }

    public void registerStudentForCourse(Student student, String courseName) {
        try {
            student.registerCourse(courseName);
            System.out.println("Successfully registered " + courseName + " for student ID " + student.getId());
        } catch (CourseAlreadyRegisteredException e) {
            System.out.println("Registration failed: " + e.getMessage());
        } finally {
            System.out.println("Registration process completed - Log recorded at " +
                    java.time.LocalDateTime.now());
        }
    }
}
