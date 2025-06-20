
import java.util.Arrays;
import java.util.Comparator;

public class E_commerce_platform {

    // Linear Search: Search by Product Name
    public static Product linearSearch(Product[] products, String targetName) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(targetName)) {
                return product;
            }
        }
        return null;
    }

    // Binary Search: Search by Product Name (Array must be sorted)
    public static Product binarySearch(Product[] products, String targetName) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int result = products[mid].productName.compareToIgnoreCase(targetName);

            if (result == 0) return products[mid];
            else if (result < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

    // Main method to test
    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Phone", "Electronics"),
            new Product(3, "Shoes", "Fashion"),
            new Product(4, "Book", "Education")
        };

        // Linear Search
        Product foundLinear = linearSearch(products, "Phone");
        System.out.println("Linear Search: " + (foundLinear != null ? foundLinear.productName : "Not Found"));

        // Sort for Binary Search
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        // Binary Search
        Product foundBinary = binarySearch(products, "Phone");
        System.out.println("Binary Search: " + (foundBinary != null ? foundBinary.productName : "Not Found"));
    }
}


class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }
}
