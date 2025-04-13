public class Account {
    private static int lastAccountNumber = 0;
    private int accountNumber;
    private String name;
    private double balance;
    
    public Account(String name, double initialBalance) {
        this.accountNumber = ++lastAccountNumber;
        this.name = name;
        this.balance = initialBalance;
    }
    
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }
    
    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
    
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Current Balance: $" + balance);
    }
}
