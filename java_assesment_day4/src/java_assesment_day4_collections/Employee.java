package java_assesment_day4_collections;

import java.util.*;

class Employee implements Comparable<Employee> {
    int empid;
    String firstname;
    String lastname;

    public Employee(int empid, String firstname, String lastname) {
        this.empid = empid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "EmpID: " + empid + ", Name: " + firstname + " " + lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empid == employee.empid; // Two employees are equal if their empid is the same
    }

    @Override
    public int hashCode() {
        return Objects.hash(empid);
    }

    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.empid, other.empid); // Default sorting by empid
    }

    // Comparator for sorting by firstname
    public static Comparator<Employee> FirstNameComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.firstname.compareTo(e2.firstname);
        }
    };
}
