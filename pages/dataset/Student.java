import java.util.Scanner;
class Student {
    String name;
    int age;
    double grade;
    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
    public void display() {
        System.out.println("Student: " + name + ", Age: " + age + ", Grade: " + grade);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.print("Enter grade: ");
        double grade = sc.nextDouble();
        Student student = new Student(name, age, grade);
        student.display();
    }
}