package com.ig.service;

import com.ig.model.Product;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    // List highest-priced product
    public Optional<Product> getHighestPricedProduct() {
        return productList.stream().max(Comparator.comparing(Product::getPrice));
    }

    // List lowest-priced product
    public Optional<Product> getLowestPricedProduct() {
        return productList.stream().min(Comparator.comparing(Product::getPrice));
    }

    // List products that already expired
    public List<Product> getExpiredProducts() {
        return productList.stream()
                .filter(product -> product.getExpiryDate().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }

    // List product names that will expire in the next 10 days
    public List<String> getExpiringProducts() {
        LocalDate today = LocalDate.now();
        return productList.stream()
                .filter(product -> product.getExpiryDate().isAfter(today) && product.getExpiryDate().isBefore(today.plusDays(10)))
                .map(Product::getName)
                .collect(Collectors.toList());
    }

    // Display count of products of different types
    public Map<String, Long> getProductCountByType() {
        return productList.stream()
                .collect(Collectors.groupingBy(Product::getType, Collectors.counting()));
    }

    // Display count of products based on Supplier name
    public Map<String, Long> getProductCountBySupplier() {
        return productList.stream()
                .collect(Collectors.groupingBy(product -> product.getSupplier().getSname(), Collectors.counting()));
    }
}
