package DataStructure.ex2;

public class Main {
      public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Keyboard", "Electronics"),
                new Product(102, "Laptop", "Electronics"),
                new Product(103, "Monitor", "Electronics"),
                new Product(104, "Mouse", "Electronics"),
                new Product(105, "Phone", "Electronics")

        };

        LinearSearch linearSearch = new LinearSearch();

        Product linearResult = linearSearch.search(products, "Mouse");

        System.out.println("Linear Search Result:");

        if (linearResult != null) {
            linearResult.display();
        } else {
            System.out.println("Product Not Found");
        }

        BinarySearch binarySearch = new BinarySearch();

        Product binaryResult = binarySearch.search(products, "Mouse");

        System.out.println("\nBinary Search Result:");

        if (binaryResult != null) {
            binaryResult.display();
        } else {
            System.out.println("Product Not Found");
        }

    }
    
}
