import java.util.Scanner;
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }
    public void deposit(double amount) {
        balance += amount;
    }
    public void withdraw(double amount) {
        if (amount <= balance) balance -= amount;
        else System.out.println("Insufficient funds");
    }
    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000);
        System.out.print("Enter deposit amount: ");
        account.deposit(sc.nextDouble());
        System.out.print("Enter withdrawal amount: ");
        account.withdraw(sc.nextDouble());
        account.displayBalance();
    }
}