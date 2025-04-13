public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;
    
    public Product(String id, String name, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void addStock(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
        }
    }
    
    public boolean removeStock(int quantity) {
        if (quantity > 0 && this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }
    
    public void updatePrice(double newPrice) {
        if (newPrice > 0) {
            this.price = newPrice;
        }
    }
    
    public double calculateValue() {
        return price * quantity;
    }
}
