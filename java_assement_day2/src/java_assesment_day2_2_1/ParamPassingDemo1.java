package java_assesment_day2_2_1;

//Student class
class Student {
 int rollno;
 String fname;

 // Constructor to initialize attributes
 public Student(int rollno, String fname) {
     this.rollno = rollno;
     this.fname = fname;
 }

 // Overloaded modify methods
 public void modify(int num) {
     num++;
 }

 public void modify(Student student) {
     student.rollno++;
 }

 public void modify(String name) {
     name = "New Name";
 }
}

public class ParamPassingDemo1 {
 public static void main(String[] args) {
     int num = 5;
     Student student = new Student(101, "John");

     System.out.println("Before modify: " + num + " " + student.rollno + " " + student.fname);
     
     // Modify method calls
     student.modify(num); // Pass by value
     student.modify(student); // Pass by reference
     student.modify(student.fname); // Pass by value (String)

     System.out.println("After modify: " + num + " " + student.rollno + " " + student.fname);
 }
}

