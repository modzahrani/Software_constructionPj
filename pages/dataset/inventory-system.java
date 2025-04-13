import java.util.HashMap;
import java.util.Scanner;

public class InventorySystem {
    private HashMap<String, Product> products;
    private Scanner scanner;
    
    public InventorySystem() {
        products = new HashMap<>();
        scanner = new Scanner(System.in);
    }
    
    public void addProduct(String id, String name, double price, int quantity) {
        Product product = new Product(id, name, price, quantity);
        products.put(id, product);
        System.out.println("Product added successfully.");
    }
    
    public void updateStock(String id, int additionalQuantity) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            product.addStock(additionalQuantity);
            System.out.println("Stock updated. New quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }
    
    public void sellProduct(String id, int quantity) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            if (product.removeStock(quantity)) {
                double salesAmount = product.getPrice() * quantity;
                System.out.printf("Sale completed. Amount: $%.2f. Remaining quantity: %d\n", 
                                 salesAmount, product.getQuantity());
            } else {
                System.out.println("Insufficient stock.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }
    
    public void displayProduct(String id) {
        if (products.containsKey(id)) {
            Product product = products.get(id);
            System.out.println("ID: " + product.getId());
            System.out.println("Name: " + product.getName());
            System.out.println("Price: $" + product.getPrice());
            System.out.println("Quantity: " + product.getQuantity());
        } else {
            System.out.println("Product not found.");
        }
    }
    
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
            return;
        }
        
        System.out.println("\nCurrent Inventory:");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-8s %-20s %-10s %-10s\n", "ID", "Name", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        
        for (Product product : products.values()) {
            System.out.printf("%-8s %-20s $%-9.2f %-10d\n", 
                             product.getId(), 
                             product.getName(), 
                             product.getPrice(), 
                             product.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }
    
    public static void main(String[] args) {
        InventorySystem inventory = new InventorySystem();
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // Add some sample products
        inventory.addProduct("P001", "Laptop", 999.99, 10);
        inventory.addProduct("P002", "Mouse", 19.99, 50);
        inventory.addProduct("P003", "Keyboard", 49.99, 30);
        
        do {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock");
            System.out.println("3. Sell Product");
            System.out.println("4. Display Product");
            System.out.println("5. Display All Products");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(id, name, price, quantity);
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter additional quantity: ");
                    int addQuantity = scanner.nextInt();
                    inventory.updateStock(updateId, addQuantity);
                    break;
                case 3:
                    System.out.print("Enter product ID: ");
                    String sellId = scanner.nextLine();
                    System.out.print("Enter quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    inventory.sellProduct(sellId, sellQuantity);
                    break;
                case 4:
                    System.out.print("Enter product ID: ");
                    String displayId = scanner.nextLine();
                    inventory.displayProduct(displayId);
                    break;
                case 5:
                    inventory.displayAllProducts();
                    break;
                case 0:
                    System.out.println("Thank you for using the Inventory System!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        
        scanner.close();
    }
}
