package DataStructure.ex2;

public class BinarySearch {
      public Product search(Product[] products, String productName) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = products[mid].productName.compareToIgnoreCase(productName);

            if (result == 0) {
                return products[mid];
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return null;
    }
    
}
