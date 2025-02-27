package streams_task_2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class ProductTest {
    public static void main(String[] args) {
        List<Product> productList = Arrays.asList(
                new Product(1, "Milk", "Dairy", 2.0, 50.0, LocalDate.of(2025, 3, 10)),
                new Product(2, "Lentils", "Pulses", 5.0, 150.0, LocalDate.of(2025, 2, 28)),
                new Product(3, "Olive Oil", "Oils", 1.0, 400.0, LocalDate.of(2025, 5, 5)),
                new Product(4, "Chips", "Snacks", 3.0, 30.0, LocalDate.of(2024, 2, 20)),  // expired
                new Product(5, "Turmeric", "Spices", 1.0, 70.0, LocalDate.of(2025, 3, 1))  // expiring soon
        );

        ProductService productService = new ProductService(productList);

        System.out.println("Highest Priced Product: " + productService.getHighestPricedProduct());
        System.out.println("Lowest Priced Product: " + productService.getLowestPricedProduct());
        System.out.println("Expired Products: " + productService.getExpiredProducts());
        System.out.println("Products Expiring in the Next 10 Days: " + productService.getExpiringSoonProducts());
        System.out.println("Product Type Counts: " + productService.getProductTypeCounts());
    }
}
