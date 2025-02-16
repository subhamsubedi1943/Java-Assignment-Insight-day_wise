package java_assesment_day2_2_1;

//Parent class Shape
abstract class Shape {
 int length;
 
 // Constructor for length
 public Shape(int length) {
     this.length = length;
 }
 
 // Abstract method to calculate area
 public abstract double calculateArea();
}

//Rectangle class
class Rectangle extends Shape {
 int height;
 
 public Rectangle(int length, int height) {
     super(length);
     this.height = height;
 }

 @Override
 public double calculateArea() {
     return length * height;
 }
}

//Square class
class Square extends Shape {

 public Square(int length) {
     super(length);
 }

 @Override
 public double calculateArea() {
     return length * length;
 }
}

//Triangle class
class Triangle extends Shape {
 int height;

 public Triangle(int length, int height) {
     super(length);
     this.height = height;
 }

 @Override
 public double calculateArea() {
     return 0.5 * length * height;
 }
}



