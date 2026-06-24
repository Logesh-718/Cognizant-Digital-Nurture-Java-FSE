package DataStructure.ex1;

public class Main {
    public static void main(String[] args){
        InventoryManager manager = new InventoryManager();
        System.out.println("Adding products...");

        manager.addProduct(new Product("P001", "Laptop", 10, 999.99));
        manager.addProduct(new Product("P002", "Smartphone", 20, 499.99));
        manager.addProduct(new Product("P001", "Laptop", 10, 999.99)); // Duplicate ID
        System.out.println("\n--- Updating a Product ---");
         manager.updateProduct("P001", 45, 949.99);

        System.out.println("\n--- Deleting a Product ---");
        manager.deleteProduct("P002");

        manager.addProduct(new Product("P001", "Duplicate Laptop", 0, 0.0));

        System.out.println("\n--- Testing Delete Non-Existent ---");
        manager.deleteProduct("P999");

        System.out.println("\n--- Final Inventory ---");
        manager.displayInventory();

    }
    
}
