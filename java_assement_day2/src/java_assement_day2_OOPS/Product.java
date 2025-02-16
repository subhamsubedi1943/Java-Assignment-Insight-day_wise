package java_assement_day2_OOPS;

class Product {
    int productNo;
    String productName;
    float price;
    int quantity;

    void setProductDetails(int productNo, String productName, float price, int quantity) {
        this.productNo = productNo;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    void displayProduct() {
        System.out.println("Product No   Product Name   Quantity   Price   Total Amount");
        System.out.println(productNo + "     " + productName + "       " + quantity + "       " + price + "       " + (price * quantity));
    }

    public static void main(String[] args) {
        Product p = new Product();
        p.setProductDetails(101, "Laptop", 50000, 2);
        p.displayProduct();
    }
}
