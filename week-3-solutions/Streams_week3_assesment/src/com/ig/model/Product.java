package com.ig.model;

import java.time.LocalDate;

public class Product {
    private Integer id;
    private String name;
    private String type;  // Ex: dairy, pulses, spices, oils, snacks
    private Double qty;
    private Double price;
    private LocalDate expiryDate;
    private Supplier supplier;

    public Product(Integer id, String name, String type, Double qty, Double price, LocalDate expiryDate, Supplier supplier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.qty = qty;
        this.price = price;
        this.expiryDate = expiryDate;
        this.supplier = supplier;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public Double getQty() { return qty; }
    public Double getPrice() { return price; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public Supplier getSupplier() { return supplier; }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", supplier=" + supplier.getSname() +
                '}';
    }
}
