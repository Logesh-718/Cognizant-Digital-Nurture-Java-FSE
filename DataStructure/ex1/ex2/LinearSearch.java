package DataStructure.ex2;

public class LinearSearch {
     public Product search(Product[] products, String productName) {

        for (Product product : products) {

            if (product.productName.equalsIgnoreCase(productName)) {
                return product;
            }

        }

        return null;
    }
    
}
