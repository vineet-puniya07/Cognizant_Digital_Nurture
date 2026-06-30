package ECommerceSearchSystem;

import java.util.Arrays;
import java.util.Comparator;

public class SearchDemo {

    public static Product linearSearch(Product[] products, String name) {

        for (Product p : products) {

            if (p.productName.equalsIgnoreCase(name))
                return p;
        }

        return null;
    }

    public static Product binarySearch(Product[] products, String name) {

        int low = 0;
        int high = products.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(name);

            if (compare == 0)
                return products[mid];

            else if (compare < 0)
                low = mid + 1;

            else
                high = mid - 1;
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {

                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Mouse", "Electronics"),
                new Product(103, "Keyboard", "Electronics"),
                new Product(104, "Camera", "Electronics"),
                new Product(105, "Mobile", "Electronics")

        };

        System.out.println("Linear Search:");

        Product result1 = linearSearch(products, "Keyboard");

        if (result1 != null)
            System.out.println(result1);
        else
            System.out.println("Product Not Found");

        Arrays.sort(products, Comparator.comparing(p -> p.productName));

        System.out.println("\nBinary Search:");

        Product result2 = binarySearch(products, "Keyboard");

        if (result2 != null)
            System.out.println(result2);
        else
            System.out.println("Product Not Found");
    }
}