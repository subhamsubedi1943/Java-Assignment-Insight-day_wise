package java_assement_day2_OOPS;

//Interface Calculator
interface Calculator {
 // Abstract methods for addition and subtraction
 double add(double a, double b);
 double subtract(double a, double b);
}

//Implementation of Calculator interface
class CalculatorImpl implements Calculator {

 // Implementing the add method
 @Override
 public double add(double a, double b) {
     return a + b;
 }

 // Implementing the subtract method
 @Override
 public double subtract(double a, double b) {
     return a - b;
 }
}

//Main class to test the Calculator
public class MainCalc {
 public static void main(String[] args) {
     // Creating object of CalculatorImpl class
     Calculator calc = new CalculatorImpl();

     // Performing addition and subtraction
     double sum = calc.add(10, 5);
     double difference = calc.subtract(10, 5);

     // Displaying the results
     System.out.println("Sum: " + sum);
     System.out.println("Difference: " + difference);
 }
}

