package buoi9.btvn;

import java.util.Arrays;
import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private String[] courses;
    private int courseCount;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.courses = new String[10];
        this.courseCount = 0;
    }

    public void registerCourse(String courseName) throws CourseAlreadyRegisteredException {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equalsIgnoreCase(courseName)) {
                throw new CourseAlreadyRegisteredException(courseName,
                        "Course '" + courseName + "' is already registered for student " + name);
            }
        }

        if (courseCount >= courses.length) {
            courses = Arrays.copyOf(courses, courses.length * 2);
        }
        courses[courseCount++] = courseName;
    }

    public String[] getCourses() {
        return Arrays.copyOf(courses, courseCount);
    }

    public void inputInfo() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter student ID: ");
                this.id = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid ID format. Please enter a number.");
            }
        }

        System.out.print("Enter student name: ");
        this.name = scanner.nextLine();
    }

    public void showInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Registered courses: " + Arrays.toString(getCourses()));
    }

    public int getId() {
        return id;
    }
}
