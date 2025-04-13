import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        System.out.println("Reversed String: " + reverse(str));
    }
    public static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}