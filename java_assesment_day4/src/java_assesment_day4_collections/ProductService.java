package java_assesment_day4_collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    static List<Product> plist = new ArrayList<>();

    public String addProduct(Product p) {
        plist.add(p);
        return "success";
    }

    public int deleteProduct(Product p) {
        if (plist.remove(p)) {
            return 1; // Success
        } else {
            return 0; // Not found
        }
    }

    public int updateProduct(Product p) {
        Optional<Product> existingProduct = plist.stream()
                .filter(prod -> prod.id.equals(p.id))
                .findFirst();

        if (existingProduct.isPresent()) {
            Product prod = existingProduct.get();
            prod.name = p.name; // Update the name 
            return 1; // Success
        } else {
            return 0; // Not found
        }
    }

    public void listProducts() {
        plist.forEach(System.out::println); // More concise way to print
    }

    public Product getProduct(Integer id) {
        return plist.stream()
                .filter(p -> p.id.equals(id))
                .findFirst()
                .orElse(null); // Return null if not found
    }
}
