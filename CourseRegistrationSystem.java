import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Course {
    private String code;
    private String title;
    private String description;
    private int capacity;
    private String schedule;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return String.format("Code: %s, Title: %s, Description: %s, Capacity: %d, Schedule: %s",
                code, title, description, capacity, schedule);
    }
}

class Student {
    private int id;
    private String name;
    private List<Course> registeredCourses;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        registeredCourses.add(course);
    }

    public void dropCourse(Course course) {
        registeredCourses.remove(course);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, Registered Courses: %s",
                id, name, registeredCourses.toString());
    }
}

public class CourseRegistrationSystem {
    private List<Course> courses;
    private List<Student> students;
    private Scanner scanner;

    public CourseRegistrationSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("Registered Students:");
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    public static void main(String[] args) {
        CourseRegistrationSystem system = new CourseRegistrationSystem();

        // Sample data
        system.addCourse(new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 50, "Mon/Wed 9:00-10:30"));
        system.addCourse(new Course("ENG201", "English Literature", "Study of classic English literature", 40, "Tue/Thu 11:00-12:30"));

        // Display available courses
        system.displayCourses();

        // You can add more functionality here for student registration, course removal, etc.
    }
}
