package java_assement_day2_OOPS;

// Employee class
class Employee1 {
    String name;
    double salary;

    // Constructor to initialize name and salary
    public Employee1(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}

// Manager class inheriting Employee class
class Manager1 extends Employee1 {
    String department;

    // Constructor to initialize name, salary, and department
    public Manager1(String name, double salary, String department) {
        super(name, salary);  // Call the Employee constructor
        this.department = department;
    }

    // Overridden toString() method to print manager's details
    public String toString() {
        return "Manager: Name: " + name + ", Department: " + department + ", Salary: " + salary;
    }
}

// Executive class inheriting Manager class
class Executive extends Manager1 {

    // Constructor to initialize name, salary, and department for Executive
    public Executive(String name, double salary, String department) {
        super(name, salary, department);  // Call the Manager constructor
    }

    // Overridden toString() method to print "Executive" followed by the manager's details
    @Override
    public String toString() {
        return "Executive: " + super.toString();  // Call the Manager's toString method
    }
}

// Main class to test the classes and methods
public class EmpTask9 {
    public static void main(String[] args) {
        // Create Manager and Executive objects
        Manager1 manager = new Manager1("John Doe", 80000, "IT");
        Executive executive = new Executive("Jane Smith", 100000, "HR");

        // Print their details using toString() method
        System.out.println(manager.toString());
        System.out.println(executive.toString());
    }
}
