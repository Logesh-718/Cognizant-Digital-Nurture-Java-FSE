package DataStructure.ex1;
import java.util.HashMap;
import java.util.Map;


public class InventoryManager{
    private Map<String, Product> inventory = new HashMap<>();
    public void addProduct(Product product){
         if (inventory.containsKey(product.getProductId())) {
            System.out.println("ERROR: Product already exists with ID: " + product.getProductId());
            return;
        }
        inventory.put(product.getProductId(), product);
        System.out.println("SUCCESS: Product added - " + product);
    }
    public void updateProduct(String productId, int newQuantity, double newPrice) {
        Product product = inventory.get(productId);
        if (product == null) {
            System.out.println("ERROR: Product not found with ID: " + productId);
            return;
        }
        product.setQuantity(newQuantity);
        product.setPrice(newPrice);
        System.out.println("SUCCESS: Product updated - " + product);
    }
    public void deleteProduct(String productId){
        if (!inventory.containsKey(productId)) {
            System.out.println("ERROR: Product not found with ID: " + productId);
            return;
        }
        inventory.remove(productId);
        System.out.println("SUCCESS: Product deleted with ID: " + productId);
    }
    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }
        System.out.println("Current Inventory:");
        for(Map.Entry<String, Product> entry : inventory.entrySet()) {
            System.out.println(entry.getValue());
        }
       
    }
}
