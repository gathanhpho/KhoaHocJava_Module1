package buoi9.btvn;

public class CourseAlreadyRegisteredException extends Exception {
    private String courseName;
    private String message;

    public CourseAlreadyRegisteredException(String courseName, String message) {
        super(message);
        this.courseName = courseName;
        this.message = message;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
