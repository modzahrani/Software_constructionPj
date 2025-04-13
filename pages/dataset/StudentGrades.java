import java.util.Scanner;
public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        int[] grades = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = sc.nextInt();
        }
        System.out.println("Average grade: " + average(grades));
    }
    public static double average(int[] grades) {
        int sum = 0;
        for (int grade : grades) sum += grade;
        return (double) sum / grades.length;
    }
}