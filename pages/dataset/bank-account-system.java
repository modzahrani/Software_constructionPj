import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSystem {
    private ArrayList<Account> accounts;
    private Scanner scanner;
    
    public BankAccountSystem() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    public void addAccount(String name, double initialBalance) {
        Account newAccount = new Account(name, initialBalance);
        accounts.add(newAccount);
        System.out.println("Account created successfully. Account number: " + newAccount.getAccountNumber());
    }
    
    public void deposit(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    
    public void withdraw(int accountNumber, double amount) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            if (account.withdraw(amount)) {
                System.out.println("Withdrawal successful. New balance: " + account.getBalance());
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Account not found.");
        }
    }
    
    public void checkBalance(int accountNumber) {
        Account account = findAccount(accountNumber);
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }
    
    private Account findAccount(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        BankAccountSystem bank = new BankAccountSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\nBank Account Management System");
            System.out.println("1. Create new account");
            System.out.println("2. Deposit money");
            System.out.println("3. Withdraw money");
            System.out.println("4. Check balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    bank.addAccount(name, initialBalance);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int accNumDeposit = scanner.nextInt();
                    System.out.print("Enter amount to deposit: ");
                    double amountDeposit = scanner.nextDouble();
                    bank.deposit(accNumDeposit, amountDeposit);
                    break;
                case 3:
                    System.out.print("Enter account number: ");
                    int accNumWithdraw = scanner.nextInt();
                    System.out.print("Enter amount to withdraw: ");
                    double amountWithdraw = scanner.nextDouble();
                    bank.withdraw(accNumWithdraw, amountWithdraw);
                    break;
                case 4:
                    System.out.print("Enter account number: ");
                    int accNumCheck = scanner.nextInt();
                    bank.checkBalance(accNumCheck);
                    break;
                case 0:
                    System.out.println("Thank you for using the Banking System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
