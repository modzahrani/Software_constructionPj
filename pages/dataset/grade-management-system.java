import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GradeManagementSystem {
    private List<Student> students;
    private List<Course> courses;
    private Scanner scanner;
    
    public GradeManagementSystem() {
        students = new ArrayList<>();
        courses = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addStudent(int id, String name) {
        Student student = new Student(id, name);
        students.add(student);
        System.out.println("Student added: " + name);
    }
    
    public void addCourse(String code, String name) {
        Course course = new Course(code, name);
        courses.add(course);
        System.out.println("Course added: " + name);
    }
    
    public void enrollStudent(int studentId, String courseCode) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        
        if (student != null && course != null) {
            student.enrollCourse(course);
            System.out.println(student.getName() + " enrolled in " + course.getName());
        } else {
            System.out.println("Student or course not found");
        }
    }
    
    public void addGrade(int studentId, String courseCode, double grade) {
        Student student = findStudent(studentId);
        Course course = findCourse(courseCode);
        
        if (student != null && course != null) {
            student.addGrade(courseCode, grade);
            System.out.println("Grade added for " + student.getName() + " in " + course.getName());
        } else {
            System.out.println("Student or course not found");
        }
    }
    
    public void displayStudentGrades(int studentId) {
        Student student = findStudent(studentId);
        
        if (student != null) {
            System.out.println("\nGrades for " + student.getName() + ":");
            student.displayGrades();
        } else {
            System.out.println("Student not found");
        }
    }
    
    public void displayCourseStudents(String courseCode) {
        Course course = findCourse(courseCode);
        
        if (course != null) {
            System.out.println("\nStudents enrolled in " + course.getName() + ":");
            for (Student student : students) {
                if (student.isEnrolledIn(courseCode)) {
                    System.out.println(student.getId() + ": " + student.getName() + 
                                      " - Grade: " + student.getGrade(courseCode));
                }
            }
        } else {
            System.out.println("Course not found");
        }
    }
    
    public void calculateGPA(int studentId) {
        Student student = findStudent(studentId);
        
        if (student != null) {
            double gpa = student.calculateGPA();
            System.out.printf("%s's GPA: %.2f\n", student.getName(), gpa);
        } else {
            System.out.println("Student not found");
        }
    }
    
    private Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
    
    private Course findCourse(String code) {
        for (Course course : courses) {
            if (course.getCode().equals(code)) {
                return course;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        GradeManagementSystem system = new GradeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        
        // Add sample data
        system.addStudent(1001, "Alice Johnson");
        system.addStudent(1002, "Bob Smith");
        system.addStudent(1003, "Charlie Brown");
        
        system.addCourse("CS101", "Introduction to Programming");
        system.addCourse("CS102", "Data Structures");
        system.addCourse("MATH101", "Calculus I");
        
        system.enrollStudent(1001, "CS101");
        system.enrollStudent(1001, "MATH101");
        system.enrollStudent(1002, "CS101");
        system.enrollStudent(1002, "CS102");
        system.enrollStudent(1003, "MATH101");
        
        system.addGrade(1001, "CS101", 92.5);
        system.addGrade(1001, "MATH101", 88.0);
        system.addGrade(1002, "CS101", 78.5);
        system.addGrade(1002, "CS102", 85.0);
        system.addGrade(1003, "MATH101", 91.0);
        
        int choice;
        do {
            System.out.println("\nGrade Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. Add Grade");
            System.out.println("5. Display Student Grades");
            System.out.println("6. Display Course Students");
            System.out.println("7. Calculate Student GPA");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    system.addStudent(studentId, studentName);
                    break;
                case 2:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    system.addCourse(courseCode, courseName);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int enrollId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course code: ");
                    String enrollCode = scanner.nextLine();
                    system.enrollStudent(enrollId, enrollCode);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int gradeStudentId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter course code: ");
                    String gradeCourseCode = scanner.nextLine();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    system.addGrade(gradeStudentId, gradeCourseCode, grade);
                    break;
                case 5:
                    System.out.print("Enter student ID: ");
                    int displayStudentId = scanner.nextInt();
                    system.displayStudentGrades(displayStudentId);
                    break;
                case 6:
                    System.out.print("Enter course code: ");
                    String displayCourseCode = scanner.nextLine();
                    system.displayCourseStudents(displayCourseCode);
                    break;
                case 7:
                    System.out.print("Enter student ID: ");
                    int gpaStudentId = scanner.nextInt();
                    system.calculateGPA(gpaStudentId);
                    break;
                case 0:
                    System.out.println("Thank you for using the Grade Management System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
