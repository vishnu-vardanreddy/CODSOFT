package CodeSoftPrgs;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Course {
    String code;
    String title;
    String description;
    int capacity;
    String schedule;
    List<Student> registeredStudents;

    public Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.registeredStudents = new ArrayList<>();
    }
}

class Student {
    String studentID;
    String name;
    List<Course> registeredCourses;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }
}

class UniversitySystem {
    List<Course> courseDatabase;
    List<Student> studentDatabase;

    public UniversitySystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }

    public void registerStudent(Student student) {
        studentDatabase.add(student);
    }

    public void displayCourseListing(Student student) {
        System.out.println("Available Courses for Student " + student.name + ":");
        for (Course course : courseDatabase) {
           
            if (!student.registeredCourses.contains(course)) {
                int availableSlots = course.capacity - course.registeredStudents.size();
                System.out.println("Course Code: " + course.code +"\n"+
                        "Title: " + course.title +"\n"+
                        "Description: " + course.description +"\n"+
                        "Capacity: " + course.capacity +"\n"+
                        "Schedule: " + course.schedule +"\n"+
                        "Available Slots: " + availableSlots);
            }
        }
    }

    public void registerStudentForCourse(Student student, Course course) {
        if (course.registeredStudents.size() < course.capacity) {
            student.registeredCourses.add(course);
            course.registeredStudents.add(student);
            System.out.println(student.name + " successfully registered for " + course.title);
        } else {
            System.out.println("Course is full. Cannot register " + student.name + " for " + course.title);
        }
    }

    public void removeStudentFromCourse(Student student, Course course) {
        student.registeredCourses.remove(course);
        course.registeredStudents.remove(student);
        System.out.println(student.name + " successfully removed from " + course.title);
    }
}

public class Task_5 {
    public static void main(String[] args) {
        UniversitySystem universitySystem = new UniversitySystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Enter Course Details");
            System.out.println("2. Enter Student Details");
            System.out.println("3. Show Course Details");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    enterCourseDetails(universitySystem, scanner);
                    break;
                case 2:
                    enterStudentDetails(universitySystem, scanner);
                    break;
                case 3:
                    
                    System.out.print("Enter Student ID: ");
                    String studentID = scanner.nextLine();
                    Student student = findStudentById(universitySystem, studentID);
                    if (student != null) {
                        universitySystem.displayCourseListing(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        } while (choice != 4);

       
        scanner.close();
    }

    private static void enterCourseDetails(UniversitySystem universitySystem, Scanner scanner) {
        System.out.println("\nEnter Course Details:");
        System.out.print("Course Code: ");
        String code = scanner.nextLine();
        System.out.print("Course Title: ");
        String title = scanner.nextLine();
        System.out.print("Course Description: ");
        String description = scanner.nextLine();
        System.out.print("Course Capacity: ");
        int capacity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        System.out.print("Course Schedule: ");
        String schedule = scanner.nextLine();

        Course course = new Course(code, title, description, capacity, schedule);
        universitySystem.addCourse(course);
    }

    private static void enterStudentDetails(UniversitySystem universitySystem, Scanner scanner) {
        System.out.println("\nEnter Student Details:");
        System.out.print("Student ID: ");
        String studentID = scanner.nextLine();
        System.out.print("Student Name: ");
        String studentName = scanner.nextLine();

        Student student = new Student(studentID, studentName);
        universitySystem.registerStudent(student);

      
        universitySystem.displayCourseListing(student);

        System.out.print("Enter Course Code to Register: ");
        String courseCode = scanner.nextLine();

     
        Course course = universitySystem.courseDatabase.stream()
                .filter(c -> c.code.equals(courseCode))
                .findFirst()
                .orElse(null);

        if (course != null) {
            universitySystem.registerStudentForCourse(student, course);
        } else {
            System.out.println("Invalid Course Code. Registration failed.");
        }
    }

    private static Student findStudentById(UniversitySystem universitySystem, String studentID) {
        return universitySystem.studentDatabase.stream()
                .filter(student -> student.studentID.equals(studentID))
                .findFirst()
                .orElse(null);
    }
}
