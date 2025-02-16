package java_assesment_day4_collections;

import java.util.HashSet;
import java.util.Set;

public class Mainstudent {
    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        Address a1 = new Address("123 Main St", "Anytown", "CA", "91234");
        Address a2 = new Address("123 Main St", "Anytown", "CA", "91234"); // Same address as a1
        Address a3 = new Address("456 Oak Ave", "Springfield", "IL", "62701");


        students.add(new Student("John", "Doe", 20, a1));
        students.add(new Student("John", "Doe", 22, a2)); // Duplicate (same name and address) - won't be added
        students.add(new Student("Jane", "Smith", 21, a3)); // Different address
        students.add(new Student("Peter", "Jones", 23, a1)); // Same address, different name


        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("Number of students: " + students.size()); // Check the size
    }
}