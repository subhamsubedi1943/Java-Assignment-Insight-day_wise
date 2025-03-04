package com.ig.ui;

import com.ig.model.Product;
import com.ig.model.Supplier;
import com.ig.service.ProductService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        Supplier supplier1 = new Supplier(1, "DairyBest");
        Supplier supplier2 = new Supplier(2, "FarmFresh");
        Supplier supplier3 = new Supplier(3, "Organic Farms");

        List<Product> products = Arrays.asList(
                new Product(101, "Milk", "Dairy", 2.0, 50.0, LocalDate.of(2024, 3, 5), supplier1),
                new Product(102, "Butter", "Dairy", 1.0, 150.0, LocalDate.of(2024, 3, 15), supplier1),
                new Product(103, "Rice", "Pulses", 5.0, 500.0, LocalDate.of(2025, 1, 10), supplier2),
                new Product(104, "Wheat", "Pulses", 3.0, 350.0, LocalDate.of(2025, 6, 20), supplier2),
                new Product(105, "Red Chilli", "Spices", 1.0, 100.0, LocalDate.of(2024, 2, 25), supplier3),
                new Product(106, "Black Pepper", "Spices", 0.5, 200.0, LocalDate.of(2024, 4, 10), supplier3),
                new Product(107, "Mustard Oil", "Oils", 1.0, 180.0, LocalDate.of(2025, 12, 5), supplier2),
                new Product(108, "Sunflower Oil", "Oils", 2.0, 210.0, LocalDate.of(2024, 3, 12), supplier2),
                new Product(109, "Potato Chips", "Snacks", 0.2, 50.0, LocalDate.of(2024, 3, 3), supplier1),
                new Product(110, "Biscuits", "Snacks", 0.3, 30.0, LocalDate.of(2024, 5, 1), supplier1)
        );

        ProductService productService = new ProductService(products);

        // Highest priced product
        productService.getHighestPricedProduct().ifPresent(product ->
                System.out.println("💰 Highest Priced Product: " + product));

        // Lowest priced product
        productService.getLowestPricedProduct().ifPresent(product ->
                System.out.println("🛒 Lowest Priced Product: " + product));

        // Expired products
        System.out.println("\n⚠️ Expired Products:");
        productService.getExpiredProducts().forEach(System.out::println);

        // Products expiring in the next 10 days
        System.out.println("\n📅 Products Expiring in Next 10 Days:");
        productService.getExpiringProducts().forEach(System.out::println);

        // Count of products by type
        System.out.println("\n📊 Product Count by Type:");
        productService.getProductCountByType().forEach((type, count) ->
                System.out.println(type + " : " + count));

        // Count of products by supplier
        System.out.println("\n🏭 Product Count by Supplier:");
        productService.getProductCountBySupplier().forEach((supplier, count) ->
                System.out.println(supplier + " : " + count));
    }
}
