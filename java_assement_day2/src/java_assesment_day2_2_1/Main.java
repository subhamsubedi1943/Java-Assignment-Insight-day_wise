package java_assesment_day2_2_1;

public class Main {
	 public static void main(String[] args) {
	     Shape[] shapes = new Shape[3];
	     shapes[0] = new Rectangle(10, 5);
	     shapes[1] = new Square(4);
	     shapes[2] = new Triangle(6, 4);

	     for (Shape shape : shapes) {
	         System.out.println("Area: " + shape.calculateArea());
	     }
	 }
	}

	
