package java_assesment_day4_collections;
import java.util.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        Set<Employee> employees = new TreeSet<>();

        employees.add(new Employee(101, "Alice", "Smith"));
        employees.add(new Employee(105, "Bob", "Johnson"));
        employees.add(new Employee(102, "Charlie", "Brown"));
        employees.add(new Employee(101, "Alice", "Smith")); // Duplicate empid - won't be added
        employees.add(new Employee(103, "David", "Lee"));
        employees.add(new Employee(106, "Eve", "Davis"));
        employees.add(new Employee(104, "Alice", "Wonderland")); //Different first name, same last name

        System.out.println("Employees (sorted by empid):");
        for (Employee emp : employees) {
            System.out.println(emp);
        }

        // Sorting by firstname
        List<Employee> employeeList = new ArrayList<>(employees); // Need a List to sort
        Collections.sort(employeeList, Employee.FirstNameComparator); // Sort by firstname

        System.out.println("\nEmployees (sorted by firstname):");
        for (Employee emp : employeeList) {
            System.out.println(emp);
        }
    }
}
