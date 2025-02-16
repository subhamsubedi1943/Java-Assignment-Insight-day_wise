package java_assesment_day4_collections;

import java.util.Scanner;

public class ProductTest {

    public static void main(String[] args) {
        ProductService ps = new ProductService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nProduct Management Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Delete Product");
            System.out.println("3. Update Product");
            System.out.println("4. List Products");
            System.out.println("5. Get Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    Product newProduct = new Product(id, name);
                    String result = ps.addProduct(newProduct);
                    System.out.println(result);
                    break;
                case 2:
                    System.out.print("Enter product ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine();
                    Product productToDelete = new Product(idToDelete, ""); // Create a dummy product for deletion
                    int deleteResult = ps.deleteProduct(productToDelete);
                    System.out.println(deleteResult == 1 ? "Product deleted successfully." : "Product not found.");
                    break;
                case 3:
                    System.out.print("Enter product ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new product name: ");
                    String newName = scanner.nextLine();
                    Product productToUpdate = new Product(idToUpdate, newName);
                    int updateResult = ps.updateProduct(productToUpdate);
                    System.out.println(updateResult == 1 ? "Product updated successfully." : "Product not found.");
                    break;
                case 4:
                    ps.listProducts();
                    break;
                case 5:
                    System.out.print("Enter product ID to get: ");
                    int idToGet = scanner.nextInt();
                    scanner.nextLine();
                    Product retrievedProduct = ps.getProduct(idToGet);
                    if (retrievedProduct != null) {
                        System.out.println(retrievedProduct);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}