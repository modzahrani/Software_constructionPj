import java.util.Scanner;
public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int a = sc.nextInt();
        System.out.print("Enter second number: ");
        int b = sc.nextInt();
        System.out.println("GCD: " + findGCD(a, b));
    }
    public static int findGCD(int a, int b) {
        if (b == 0) return a;
        return findGCD(b, a % b);
    }
}