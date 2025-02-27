package streams_task_2;
import java.util.stream.Collectors;
import java.time.LocalDate;
import java.util.*;

class ProductService {
    private List<Product> products;

    public ProductService(List<Product> products) {
        this.products = products;
    }

    // List the highest priced product
    public Product getHighestPricedProduct() {
        return products.stream()
                .max(Comparator.comparingDouble(p -> p.price))
                .orElse(null);
    }

    // List the lowest priced product
    public Product getLowestPricedProduct() {
        return products.stream()
                .min(Comparator.comparingDouble(p -> p.price))
                .orElse(null);
    }

    // List products that are already expired
    public List<Product> getExpiredProducts() {
        LocalDate today = LocalDate.now();
        return products.stream()
                .filter(p -> p.expiryDate.isBefore(today))
                .collect(Collectors.toList());
    }

    // List product names that will expire in the next 10 days
    public List<String> getExpiringSoonProducts() {
        LocalDate today = LocalDate.now();
        LocalDate tenDaysLater = today.plusDays(10);
        return products.stream()
                .filter(p -> !p.expiryDate.isBefore(today) && p.expiryDate.isBefore(tenDaysLater))
                .map(p -> p.name)
                .collect(Collectors.toList());
    }

    // Display the count of products of different types
    public Map<String, Long> getProductTypeCounts() {
        return products.stream()
                .collect(Collectors.groupingBy(p -> p.type, Collectors.counting()));
    }
}

