package java_assesment_day4_collections_task1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class IODemo {

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\SubhamSubedi\\eclipse-workspace\\java_assesment_day4\\src\\java_assesment_day4_collections_task1\\product"; 
        ProductService ps = new ProductService();

        try {
            ps.loadProductsFromFile(filename);
        } catch (IOException e) {
            System.err.println("Error loading products: " + e.getMessage());
            return;
        }

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProduct Operations:");
            System.out.println("1. Get Price by ID");
            System.out.println("2. Get Product by ID");
            System.out.println("3. List Products");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int idForPrice = scanner.nextInt();
                    Double price = ps.getPricebyId(idForPrice);
                    if (price != null) {
                        System.out.println("Price: " + price);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 2:
                    System.out.print("Enter product ID: ");
                    int idForProduct = scanner.nextInt();
                    Product product = ps.getProductById(idForProduct);
                    if (product != null) {
                        System.out.println(product);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 3:
                    List<Product> allProducts = ps.listProducts();
                    for (Product p : allProducts) {
                        System.out.println(p);
                    }
                    break;
                case 4:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}