// Abstract class Employee
package java_assement_day2_OOPS;

abstract class Employee {
    // Attributes
    int empid;
    String empname;

    // Concrete methods
    public void input(int id, String name) {
        this.empid = id;
        this.empname = name;
    }

    public void output() {
        System.out.println("Employee ID: " + empid);
        System.out.println("Employee Name: " + empname);
    }

    // Abstract method to be overridden
    public abstract void roles_Responsibilities();
}

// Subclass Manager that overrides abstract method
class Manager extends Employee {

    @Override
    public void roles_Responsibilities() {
        System.out.println("Manager's responsibilities: Managing team, overseeing projects, making key decisions.");
    }
}

// Main class to invoke methods
public class MainEmployee {
    public static void main(String[] args) {
        //  instance of Manager class
        Manager manager = new Manager();

        //  concrete methods
        manager.input(101, "John Doe");
        manager.output();

        //  abstract method implemented in Manager class
        manager.roles_Responsibilities();
    }
}
