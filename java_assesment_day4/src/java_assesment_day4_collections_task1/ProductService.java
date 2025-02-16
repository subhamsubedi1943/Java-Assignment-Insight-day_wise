package java_assesment_day4_collections_task1;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ProductService {

    List<Product> products = new ArrayList<>();

    Double getPricebyId(Integer id) {
        for (Product p : products) {
            if (p.id.equals(id)) {
                return p.price;
            }
        }
        return null;
    }

    Product getProductById(Integer id) {
        for (Product p : products) {
            if (p.id.equals(id)) {
                return p;
            }
        }
        return null;
    }

    List<Product> listProducts() {
        return products;
    }

    public void loadProductsFromFile(String filename) throws IOException {
        try (BufferedReader b = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = b.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    try {
                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        int qty = Integer.parseInt(parts[2].trim());
                        double price = Double.parseDouble(parts[3].trim());
                        Product p = new Product(id, name, qty, price);
                        products.add(p);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing line: " + line + ". Skipping.");
                    }
                }
            }
        }
    }
}