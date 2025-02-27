package streams_task_2;
import java.time.LocalDate;

public class Product {
	Integer id;
	String name;
	String type;
	Double qty;
	Double price;
	LocalDate expiryDate;
	
	public Product(Integer id,String name,String type,Double qty,Double price,LocalDate expiryDate) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.qty=qty;
		this.price=price;
		this.expiryDate=expiryDate;
		
	}
	public String toString() {
		return "Product ID: " + id + ", Name: " + name + ", Type: " + type +
                ", Qty: " + qty + ", Price: " + price + ", Expiry Date: " + expiryDate;	
		}
}
